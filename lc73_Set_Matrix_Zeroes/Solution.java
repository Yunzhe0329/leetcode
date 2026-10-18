package lc73_Set_Matrix_Zeroes;

import java.util.Arrays;

class Solution {

    public int[][] setZeros(int[][] matrix) {
        // 如果 matrix[i][j] = 0 -> 第 i row, 第 j col 的 value = 0
        // Follow-up 能否用 Contant space 解決這題?
        // 先掃描過第一列、第一行，有看到0就把flag 設為 true
        // 從(1,1)開始掃描，有看到 0 就是把第一行或第一列標成0
        // 標記完成之後，第一行、第一列就是要set0的位置
        // 逐一處理，最後回頭處理第一行、第一列
        int m = matrix.length;
        int n = matrix[0].length;
        // int[] row = new int[m];
        // int[] col = new int[n];
        boolean firstRow = false, firstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstCol = true;
                break;
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
        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRow) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstCol) {
            for (int r = 0; r < n; r++) {
                matrix[r][0] = 0;
            }
        }
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