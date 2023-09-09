package tree;

import static tree.InvertTree.invertTree;
import static tree.SameTree.isSameTree;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-9);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
