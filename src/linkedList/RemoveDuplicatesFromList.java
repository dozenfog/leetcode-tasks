package linkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicatesFromList {
    public static void main(String[] args) {
        ListNode node = new ListNode(-9);
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(deleteDuplicates(node));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        List<Integer> l = map.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).sorted().toList();
        ListNode listNode = null;
        for (int i = l.size() - 1; i >= 0; i--) {
            listNode = new ListNode(l.get(i), listNode);
        }
        return listNode;
    }
}
