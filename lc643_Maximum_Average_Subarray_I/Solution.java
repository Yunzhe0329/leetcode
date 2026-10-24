package lc643_Maximum_Average_Subarray_I;

class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int result = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            result = Math.max(result, sum);
        }

        return (double) result / k;

    }

    void main() {
        int[] nums1 = { 1, 12, -5, -6, 50, 3 };
        int k1 = 4;
        IO.println(findMaxAverage(nums1, k1));
    }
}