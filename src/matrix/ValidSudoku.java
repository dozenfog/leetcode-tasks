package matrix;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '1', '9'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        int[] numbers = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Integer.parseInt(String.valueOf(board[i][j]));
                    if (numbers[num - 1] == 1) return false;
                    else numbers[num - 1] = 1;
                }
            }
            for (int i1 = 0; i1 < 9; i1++) {
                numbers[i1] = 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            numbers[i] = 0;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = Integer.parseInt(String.valueOf(board[j][i]));
                    if (numbers[num - 1] == 1) return false;
                    else numbers[num - 1] = 1;
                }
            }
            for (int i1 = 0; i1 < 9; i1++) {
                numbers[i1] = 0;
            }
        }
        int i = 0, j = 0;

        while (i != 9 && j != 9) {
            if (board[i][j] != '.') {
                int num = Integer.parseInt(String.valueOf(board[i][j]));
                if (numbers[num - 1] == 1) return false;
                else numbers[num - 1] = 1;
            }
            if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                if (j == 8) {
                    j = 0;
                    i++;
                } else {
                    j++;
                    i -= 2;
                }
                for (int i1 = 0; i1 < 9; i1++) {
                    numbers[i1] = 0;
                }
            } else if ((j + 1) % 3 == 0) {
                i++;
                j -= 2;
            } else j++;
        }
        return true;
    }
}
