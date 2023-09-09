package tree;

import java.util.ArrayList;
import java.util.List;

public class MinDiffInTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(8));
        System.out.println(getMinimumDifference(treeNode));
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorder(root, l);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < l.size(); i++) {
            if (Math.abs(l.get(i) - l.get(i - 1)) < min) min = Math.abs(l.get(i) - l.get(i - 1));
        }
        return min;
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
