package tree;

public class SameTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-9);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node3.left = node4;

        TreeNode node5 = new TreeNode(-9);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(7);
        node5.left = node6;
        node5.right = node7;
        node6.left = node8;
        node8.left = node9;
        System.out.println(isSameTree(node, node5));
    }

    //can be simpler
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.left == null && q.left == null) {
            return isSameTree(p.right, q.right) && (p.val == q.val);
        }
        if (p.right == null && q.right == null) {
            return isSameTree(p.left, q.left) && (p.val == q.val);
        }
        if (p.left == null || p.right == null || q.left == null || q.right == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (p.val == q.val);
    }
}
