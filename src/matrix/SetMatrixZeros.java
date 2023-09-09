package matrix;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        //int[][] matrix = new int[][]{{1, 0}};
        //int[][] matrix = new int[][]{{0, 1}};
        //int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        //int[][] matrix = new int[][]{{-4, -2147483648, 6, -7, 0}, {-8, 6, -8, -6, 0}, {2147483647, 2, -9, -6, -10}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) return;
        boolean existsZerosRow = false;
        boolean existsZerosCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        existsZerosCol = true;
                    }
                    if (j == 0) {
                        existsZerosRow = true;
                    }
                    if (i != 0 && j != 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }
        if (existsZerosRow || existsZerosCol) {
            for (int i = 0; i < Math.max(matrix.length, matrix[0].length); i++) {
                if (matrix[0].length > i && existsZerosCol)
                    matrix[0][i] = 0;
                if (matrix.length > i && existsZerosRow)
                    matrix[i][0] = 0;
            }
        }
    }
}
