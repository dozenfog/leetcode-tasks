package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CacheUsingList {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        System.out.println(cache.head);
        System.out.println(cache.tail);
    }

}

class LRUCache {
    Map<Integer, ListNode> map = new HashMap<>((int) (2 * Math.pow(10, 5)));
    ListNode head = null;
    ListNode tail = null;

    int size = 0;
    int capacity;

    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "linkedList.ListNode{" +
                    "key=" + key +
                    ", val=" + val +
                    ", next=" + (next == null ? null : "(" + next.key + ", " + next.val + ")") +
                    ", prev=" + (prev == null ? null : "(" + prev.key + ", " + prev.val + ")") +
                    '}';
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            if (cur != head) {
                cur.prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = cur.prev;
                } else tail = tail.prev;
                cur.prev = null;
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            return cur.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (size == capacity) {
                map.remove(tail.key);
                if (tail.prev != null) {
                    tail.prev.next = null;
                }
                tail = tail.prev;
            } else size++;
            ListNode listNode = new ListNode(key, value);
            if (head != null) {
                listNode.next = head;
                head.prev = listNode;
            }
            head = listNode;
            if (tail == null) tail = listNode;
            map.put(key, listNode);
        } else {
            ListNode cur = map.get(key);
            cur.val = value;
            map.put(key, cur);
            if (cur != head) {
                cur.prev.next = cur.next;
                if (cur != tail)
                    cur.next.prev = cur.prev;
                else tail = cur.prev;
                cur.prev = null;
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
        }
    }
}
