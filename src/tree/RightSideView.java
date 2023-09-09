package tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(rightSideView(treeNode));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        int h = height(root);
        return view(root, h);
    }

    public static List<Integer> view(TreeNode root, int height) {
        if (root == null) return new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        if (root.right != null) {
            List<Integer> right = view(root.right, height - 1);
            l.addAll(right);
            if (l.size() == height) return l;
        }
        if (root.left != null) {
            List<Integer> l1 = view(root.left, height - 1);
            if (l.size() - 1 < l1.size())
                l.addAll(l1.subList(l.size() - 1, l1.size()));
        }
        return l;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
