package linkedList;

public class AddTwoLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(2);
        node.next = node1;
        //node1.next = node2;
        node3.next = node4;
        //node2.next = node3;
        //node2.next.next = node4;
        System.out.println(addTwoNumbers(node, node3).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null, curr = null;
        int curringOne = 0;
        while (l1 != null && l2 != null) {
            if (res == null) {
                res = curr = new ListNode((l1.val + l2.val + curringOne) % 10);
            } else {
                curr.next = new ListNode((l1.val + l2.val + curringOne) % 10);
                curr = curr.next;
            }
            if (l1.val + l2.val + curringOne > 9) curringOne = 1;
            else curringOne = 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curr.next = new ListNode((l1.val + curringOne) % 10);
            if (l1.val + curringOne > 9) curringOne = 1;
            else curringOne = 0;
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr.next = new ListNode((l2.val + curringOne) % 10);
            if (l2.val + curringOne > 9) curringOne = 1;
            else curringOne = 0;
            curr = curr.next;
            l2 = l2.next;
        }
        if (curringOne == 1) curr.next = new ListNode(1);
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "linkedList.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
