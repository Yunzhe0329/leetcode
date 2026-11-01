package lc453_Minimum_Moves_to_Equal_Array_Elements;

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}