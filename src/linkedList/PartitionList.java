package linkedList;

public class PartitionList {
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
        System.out.println(partition(node, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode less = null, curLess = less, greaterEqual = null, curGreater = greaterEqual;
        while (head != null) {
            if (head.val < x) {
                if (less == null) {
                    curLess = less = new ListNode(head.val);
                } else {
                    curLess.next = new ListNode(head.val);
                    curLess = curLess.next;
                }
            } else {
                if (greaterEqual == null) {
                    curGreater = greaterEqual = new ListNode(head.val);
                } else {
                    curGreater.next = new ListNode(head.val);
                    curGreater = curGreater.next;
                }
            }
            head = head.next;
        }
        if (less == null) return greaterEqual;
        else if (greaterEqual == null) return less;
        curLess.next = greaterEqual;
        return less;
    }
}
