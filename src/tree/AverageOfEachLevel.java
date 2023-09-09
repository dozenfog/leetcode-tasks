package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AverageOfEachLevel {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(averageOfLevels(treeNode));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Map.Entry<Long, Long>> res = new ArrayList<>((int) Math.pow(10, 4));
        for (int i = 0; i < (int) Math.pow(10, 4); i++) {
            res.add(Map.entry(0L, 0L));
        }
        averageOfLevels(root, 0, res);
        List<Double> l = new ArrayList<>();
        for (Map.Entry<Long, Long> re : res) {
            if (re.getValue() == 0) break;
            l.add(((double) re.getKey()) / re.getValue());
        }
        return l;
    }

    public static void averageOfLevels(TreeNode root, int height, List<Map.Entry<Long, Long>> list) {
        if (root == null) return;
        list.set(height, Map.entry(list.get(height).getKey() + root.val, list.get(height).getValue() + 1));

        if (root.left != null) {
            averageOfLevels(root.left, height + 1, list);
        }
        if (root.right != null) {
            averageOfLevels(root.right, height + 1, list);
        }
    }
}
