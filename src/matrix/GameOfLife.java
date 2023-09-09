package matrix;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void gameOfLife(int[][] board) {
        if (board.length == 1 && board[0].length == 1) board[0][0] = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, board.length); k++) {
                    for (int l = Math.max(j - 1, 0); l < Math.min(j + 2, board[0].length); l++) {
                        if ((k != i || l != j) && board[k][l] == 1 || board[k][l] == -1) count++;
                    }
                }
                if (board[i][j] == 0 && count == 3) board[i][j] = 2;
                else if (board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = -1;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) board[i][j]++;
                else if (board[i][j] == 2) board[i][j]--;
            }
        }
    }
}
