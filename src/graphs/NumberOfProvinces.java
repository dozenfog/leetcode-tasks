package graphs;

import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] board = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(board));
    }

    //can be solved by removing all adjacent with recursion
    public static int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1) return 1;
        Queue<Integer> toVisit = new PriorityQueue<>();
        int i = 0, res = 0;
        while (true) {
            isConnected[i][i] = 2;
            for (int j = 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    toVisit.add(j);
                }
            }
            while (!toVisit.isEmpty()) {
                int next = toVisit.remove();
                isConnected[next][next] = 2;
                for (int j = 0; j < isConnected[next].length; j++) {
                    if (next != j && isConnected[j][j] != 2 && isConnected[next][j] == 1) {
                        toVisit.add(j);
                        isConnected[next][j] = 2;
                    }
                }
            }
            res++;
            while (i < isConnected.length && isConnected[i][i] == 2) i++;
            if (i == isConnected.length) return res;
        }
    }
}
