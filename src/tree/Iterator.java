package tree;

import java.util.Stack;

public class Iterator {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8, new TreeNode(3, null, new TreeNode(9, new TreeNode(9),
                new TreeNode(5))), new TreeNode(5));
        BSTIterator iterator = new BSTIterator(treeNode);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}

class BSTIterator {
    Stack<Integer> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        stack.push(root.val);
        inorder(root.left);
    }

    public int next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.empty();
    }
}
