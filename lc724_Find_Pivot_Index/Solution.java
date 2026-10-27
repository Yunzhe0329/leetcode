package lc724_Find_Pivot_Index;

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return -1;
        int leftSum = 0;
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}