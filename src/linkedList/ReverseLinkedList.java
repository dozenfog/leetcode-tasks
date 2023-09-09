package linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(-9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(reverseBetween(node, 1, 4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        if (head == null || head.next == null) return head;
        int index = 0;
        ListNode prev = null, res = head;
        if (left != 1) {
            while (index < left - 2) {
                head = head.next;
                index++;
            }
            prev = head;
            head = head.next;
            index++;
        }
        ListNode start = new ListNode(head.val);
        head = head.next;
        while (index < right - 1) {
            start = new ListNode(head.val, start);
            head = head.next;
            index++;
        }
        if (prev != null) {
            prev.next = start;
        } else {
            res = start;
        }
        while (start.next != null) {
            start = start.next;
        }
        start.next = head;
        return res;
    }
}
