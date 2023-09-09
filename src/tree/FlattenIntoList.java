package tree;

public class FlattenIntoList {
    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(2, new TreeNode(1, new TreeNode(0, new TreeNode(2), null),
                new TreeNode(7, new TreeNode(1), new TreeNode(0, new TreeNode(7), null))),
                new TreeNode(3, new TreeNode(9), new TreeNode(1, new TreeNode(8), new TreeNode(8))));*/
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        flatten(treeNode);
        System.out.println(treeNode);
    }

    public static void flatten(TreeNode root) {
        flattenLeft(root);
    }

    public static TreeNode flattenLeft(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode right = root.right;
        if (root.left != null) {
            TreeNode left = flattenLeft(root.left);
            root.right = left;
            flattenLeft(right);
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            root.left = null;
        } else flattenLeft(root.right);
        return root;
    }
}
