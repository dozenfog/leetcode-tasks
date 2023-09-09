package tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPreorder {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        /*int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 1, 3};*/
        /*int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};*/
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        Map<Integer, Map.Entry<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            if (!map.containsKey(preorder[i])) {
                map.put(preorder[i], Map.entry(i, -1));
            } else map.put(preorder[i], Map.entry(i, map.get(preorder[i]).getValue()));
            if (!map.containsKey(inorder[i])) {
                map.put(inorder[i], Map.entry(-1, i));
            } else map.put(inorder[i], Map.entry(map.get(inorder[i]).getKey(), i));
        }
        return constructSubTree(0, preorder.length - 1, preorder, inorder, map);
    }

    public static TreeNode constructSubTree(int i, int j, int[] preorder, int[] inorder, Map<Integer, Map.Entry<Integer, Integer>> map) {
        if (i > j) return null;
        TreeNode res = new TreeNode(preorder[i]);
        if (i == j) return res;
        if (j == i + 1) {
            int index = i;
            int indexj = j;
            int k = Math.max(0, i - 1);
            if (index != 0 && preorder[k] != inorder[k]) {
                index--;
                indexj--;
            }
            if (preorder[i] != inorder[index]) {
                res.left = new TreeNode(inorder[index]);
            }
            if (preorder[j] == inorder[indexj]) res.right = new TreeNode(preorder[j]);
            return res;
        }
        int start = map.get(preorder[i]).getKey() + 1, end = map.get(preorder[i]).getValue();
        res.left = constructSubTree(start, end, preorder, inorder, map);
        res.right = constructSubTree(end + 1, preorder.length - 1, preorder, inorder, map);
        return res;
    }
}
