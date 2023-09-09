package tree;

public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        System.out.println(hasPathSum(treeNode, 99));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return (root.right != null && hasPathSum(root.right, targetSum - root.val))
                || (root.left != null && hasPathSum(root.left, targetSum - root.val));
    }
}
