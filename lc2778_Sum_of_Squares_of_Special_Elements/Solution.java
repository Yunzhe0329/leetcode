package lc2778_Sum_of_Squares_of_Special_Elements;

class Solution {
    public int sumOfSquares(int[] nums) {
        // given a 1-indexed array of length n
        // nums = [1, 2, 3, 4], n = 4
        // Return the sum of the squares of all special elements of nums.
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            if (n % (i + 1) == 0) {
                result += nums[i] * nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = new int[] { 1, 2, 3, 4 };
        int[] nums2 = new int[] { 2, 7, 1, 19, 18, 3 };
        System.out.println(sol.sumOfSquares(nums1)); // 21
        System.out.println(sol.sumOfSquares(nums2)); // 63

    }
}