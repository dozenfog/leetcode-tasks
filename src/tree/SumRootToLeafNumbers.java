package tree;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8, new TreeNode(3, null, new TreeNode(9, new TreeNode(9), new TreeNode(5))), new TreeNode(5));
        System.out.println(sumNumbers(treeNode));
    }

    public static int sumNumbers(TreeNode root) {
        return count(root, 0);
    }

    public static int count(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        int left = count(root.left, sum);
        int right = count(root.right, sum);
        return left + right == 0 ? sum : left + right;
    }
}
