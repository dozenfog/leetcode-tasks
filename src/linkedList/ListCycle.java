package linkedList;

public class ListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node = new ListNode(3);
        node1.next = node;
        node.next = node1;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur.next != null && next.next != null && next.next.next != null) {
            cur = cur.next;
            next = next.next.next;
            if (cur.next == next.next) return true;
        }
        return false;
    }
}
