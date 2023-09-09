package linkedList;

public class RotateListToRight {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(rotateRight(node, 10));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode listNode = null;
        while (head != null) {
            listNode = new ListNode(head.val, listNode);
            head = head.next;
        }
        ListNode first = null, list = listNode, second = null;
        int counter = 0;
        while (k > 0) {
            if (list == null) {
                first = null;
                list = listNode;
                k %= counter;
                if (k == 0) break;
            }
            first = new ListNode(list.val, first);
            list = list.next;
            k--;
            counter++;
        }
        while (list != null) {
            second = new ListNode(list.val, second);
            list = list.next;
        }
        if (first != null) {
            ListNode cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = second;
            return first;
        } else return second;
    }
}
