package tree;

import java.util.ArrayList;
import java.util.List;

public class ValidSearchTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i) <= l.get(i - 1)) return false;
        }
        return true;
    }

    public static void inorder(TreeNode root, List<Integer> l) {
        if (root != null && root.left == null && root.right == null) {
            l.add(root.val);
            return;
        }
        if (root.left != null)
            inorder(root.left, l);
        l.add(root.val);
        if (root.right != null)
            inorder(root.right, l);
    }
}
