package lc3736_Minimum_Moves_to_Equal_Array_Elements_III;

class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int result = 0;
        for (int num : nums) {
            result += max - num;
        }

        return result;
    }

    void main() {
        int[] nums = { 2, 1, 3 };
        IO.println(minMoves(nums));
    }
}