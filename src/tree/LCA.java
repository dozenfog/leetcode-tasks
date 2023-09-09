package tree;

public class LCA {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(lowestCommonAncestor(treeNode, new TreeNode(4), new TreeNode(9)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val) {
            return root;
        }
        if (root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else return left != null ? left : right;
    }
}
