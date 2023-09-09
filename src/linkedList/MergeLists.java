package linkedList;

public class MergeLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(-9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node.next = node1;
        node1.next = node2;
        node3.next = node4;
        //node2.next = node3;

        //node2.next.next = node4;
        System.out.println(mergeTwoLists(node, node3));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode res = null, curr = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (res == null) res = curr = list1;
                else {
                    curr.next = list1;
                    curr = curr.next;
                }
                list1 = list1.next;
            } else {
                if (res == null) res = curr = list2;
                else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return res;
    }
}
