package graphs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] board = {{2, 2}, {1, 1}, {0, 0}, {2, 0}};
        System.out.println(orangesRotting(board));
    }

    public static int orangesRotting(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] == 1 ? -1 : 0;
        }
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.add(Map.entry(i, j));
            }
        }
        int minutes = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Map.Entry<Integer, Integer> orange = queue.remove();
                if (grid[orange.getKey()][orange.getValue()] <= 2) {
                    grid[orange.getKey()][orange.getValue()] = minutes;
                    for (int i1 = Math.max(orange.getKey() - 1, 0); i1 < Math.min(grid.length, orange.getKey() + 2); i1++) {
                        for (int j1 = Math.max(orange.getValue() - 1, 0); j1 < Math.min(grid[orange.getKey()].length, orange.getValue() + 2); j1++) {
                            if (((i1 != orange.getKey() && j1 == orange.getValue())
                                    || (i1 == orange.getKey() && j1 != orange.getValue())) && grid[i1][j1] == 1) {
                                queue.add(Map.entry(i1, j1));
                            }
                        }
                    }
                }
                size--;
            }
            minutes++;
        }
        int max = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) return -1;
                max = Math.max(max, anInt);
            }
        }
        return max == 0 ? 0 : max - 2;
    }
}
