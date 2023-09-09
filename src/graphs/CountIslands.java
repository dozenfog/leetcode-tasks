package graphs;

import java.util.Map;
import java.util.Stack;

public class CountIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    stack.push(Map.entry(i, j));
                    while (!stack.empty()) {
                        Map.Entry<Integer, Integer> pair = stack.pop();
                        grid[pair.getKey()][pair.getValue()] = '2';
                        for (int k = Math.max(0, pair.getKey() - 1); k < Math.min(grid.length, pair.getKey() + 2); k++) {
                            for (int l = Math.max(0, pair.getValue() - 1); l < Math.min(grid[i].length, pair.getValue() + 2); l++) {
                                if ((k == pair.getKey() || l == pair.getValue()) && grid[k][l] == '1')
                                    stack.push(Map.entry(k, l));
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
}
