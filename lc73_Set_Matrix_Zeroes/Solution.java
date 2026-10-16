package lc73_Set_Matrix_Zeroes;

import java.util.Arrays;

class Solution {

    public int[][] setZeros(int[][] matrix) {
        // 如果 matrix[i][j] = 0 -> 第 i row, 第 j col 的 value = 0
        // Follow-up 能否用 Contant space 解決這題?
        int m = matrix.length;
        int n = matrix[0].length;
        // int[] row = new int[m];
        // int[] col = new int[n];
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstCol = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (matrix[i][j] == 0) {
        // row[i] = 1;
        // col[j] = 1;
        // }
        // }
        // }

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (row[i] == 1 || col[j] == 1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }
        return matrix;

    }

    void main() {
        int[][] matrix1 = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        IO.println(Arrays.deepToString(setZeros(matrix1)));

        int[][] matrix2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        IO.println(Arrays.deepToString(setZeros(matrix2)));
    }
}