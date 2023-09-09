package matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //or transpose & mirror vertically
    public static void rotate(int[][] matrix) {
        if (matrix.length <= 1) return;
        int i = 0, j = 0, prevVal = matrix[0][0], curVal, k = 0;
        while (!(k == 0 && i == j && j >= matrix.length / 2)) {
            if (k == 4) {
                j++;
                if (j == matrix.length - 1 - i) {
                    i++;
                    j = i;
                    k = 0;
                    prevVal = matrix[i][j];
                    continue;
                } else {
                    k = 0;
                    prevVal = matrix[i][j];
                }
            }
            curVal = matrix[j][matrix.length - 1 - i];
            matrix[j][matrix.length - 1 - i] = prevVal;
            prevVal = curVal;
            int temp = j;
            j = matrix.length - 1 - i;
            i = temp;
            k++;
        }
    }
}
