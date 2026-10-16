package lc73_Set_Matrix_Zeroes;

class Solution {

    public void setZeros(int[][] matrix) {
        // 如果 matrix[i][j] = 0 -> 第 i row, 第 j col 的 value = 0
        // Follow-up 能否用 Contant space 解決這題?

        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    void main() {

    }
}