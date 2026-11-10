package lc2210_Count_Hills_and_Valleys_in_an_Array;

// LeetCode 2210. Count Hills and Valleys in an Array
class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (isHillOrValley(nums, i, prev)) {
                count++;
            }
            prev = nums[i];
        }
        return count;
    }

    private boolean isHillOrValley(int[] arr, int idx, int prev) {
        return (arr[idx] > prev && arr[idx] > arr[idx + 1])
                || (arr[idx] < prev && arr[idx] < arr[idx + 1]);
    }
}