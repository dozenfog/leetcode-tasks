package tree;

public class InvertTree {
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
        System.out.println(invertTree(node));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
