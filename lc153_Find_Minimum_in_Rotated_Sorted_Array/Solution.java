package lc153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {

    public int findMin(int[] nums) {

        // O(n)
        // int n = nums.length;
        // for (int i = 0; i < n - 1; i++) {
        // if (nums[i] > nums[i + 1]) {
        // return nums[i + 1];
        // }
        // }

        // return nums[0];
        // O(n)

        // 題目要求要 log(n)
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];

    }
}