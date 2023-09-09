package linkedList;

public class MergeKLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node1 = new ListNode(2, new ListNode(5, new ListNode(77, new ListNode(78, new ListNode(105)))));
        System.out.println(mergeKLists(new ListNode[]{node, node1}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return divideAndConquer(lists, 0, lists.length);
    }

    public static ListNode divideAndConquer(ListNode[] lists, int left, int right) {
        if (left == right && left < lists.length) return lists[left];
        if (left == right) return null;
        int m = (left + right) / 2;
        return merge(divideAndConquer(lists, left, m), divideAndConquer(lists, m + 1, right));
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode cur = null, res = cur;
        while (left != null && right != null) {
            if (cur == null) {
                if (left.val <= right.val) {
                    cur = left;
                    left = left.next;
                } else {
                    cur = right;
                    right = right.next;
                }
                res = cur;
            } else {
                if (left.val <= right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
        }
        while (left != null) {
            if (cur == null) {
                cur = left;
                left = left.next;
                res = cur;
            } else {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }
        }
        while (right != null) {
            if (cur == null) {
                cur = right;
                right = right.next;
                res = cur;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        return res;
    }
}
