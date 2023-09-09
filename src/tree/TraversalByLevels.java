package tree;

import java.util.*;

public class TraversalByLevels {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<Deque<Integer>> list = new ArrayList<>(2000);
        for (int i = 0; i < 2000; i++) {
            list.add(new ArrayDeque<>());
        }
        levelOrder(root, 0, list);
        list.removeIf(Deque::isEmpty);
        return list.stream().map(l -> (List<Integer>) new ArrayList<>(l)).toList();
    }

    //if not zigzag then erase height %2 ==0 check && add to end always
    public static void levelOrder(TreeNode root, int height, List<Deque<Integer>> list) {
        if (root == null) return;
        if (height % 2 == 0) {
            list.get(height).addFirst(root.val);
            if (root.right != null) {
                levelOrder(root.right, height + 1, list);
            }
            if (root.left != null) {
                levelOrder(root.left, height + 1, list);
            }
        } else {
            list.get(height).addLast(root.val);
            if (root.left != null) {
                levelOrder(root.left, height + 1, list);
            }
            if (root.right != null) {
                levelOrder(root.right, height + 1, list);
            }
        }
    }

}
