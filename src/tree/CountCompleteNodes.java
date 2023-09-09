package tree;

public class CountCompleteNodes {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(9)), new TreeNode(0));
        System.out.println(countNodes(treeNode));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root);
        return leaves(root, h - 1) + (int) Math.pow(2, h - 1) - 1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int leaves(TreeNode root, int counter) {
        if (root.left == null && root.right == null && counter == 0) return 1;
        else if (root.left == null && root.right == null) return 0;
        return (root.left == null ? 0 : leaves(root.left, counter - 1)) + (root.right == null ? 0 : leaves(root.right, counter - 1));
    }
}
