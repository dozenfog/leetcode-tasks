package linkedList;

public class RemoveNodeFromEndList {
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
        System.out.println(removeNthFromEnd(node, 4));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode fast = head, slow = head;
        int index = 0;
        while (index < n) {
            fast = fast.next;
            index++;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
