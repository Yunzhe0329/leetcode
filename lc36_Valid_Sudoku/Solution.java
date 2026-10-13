package lc36_Valid_Sudoku;

import java.util.*;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        for (int r = 0; r < 9; r++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[r][i] == '.')
                    continue;
                if (seen.contains(board[r][i])) {
                    return false;
                }
                seen.add(board[r][i]);
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][i] == '.')
                    continue;
                if (seen.contains(board[r][i])) {
                    return false;
                }
                seen.add(board[r][i]);
            }
        }
        for (int sq = 0; sq < 9; sq++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    // sq / 3：前面已經排滿了幾排 → 所以是第幾row
                    int box_r = (sq / 3) * 3 + r;
                    // sq % 3：在目前這一排裡數到第幾個 → 所以是第幾col
                    int box_c = (sq % 3) * 3 + c;
                    if (board[box_r][box_c] == '.')
                        continue;
                    if (seen.contains(board[box_r][box_c])) {
                        return false;
                    }
                    seen.add(board[box_r][box_c]);
                }
            }
        }
        return true;

    }

    void main() {
        char[][] board1 = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        IO.println(isValidSudoku(board1));
    }
}