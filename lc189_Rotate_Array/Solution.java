package lc189_Rotate_Array;

class Solution {
    public void rotate(int[] nums, int k) {
        // rotate the array to the right by k
        // ---- 用額外O(n) space
        // int n = nums.length;
        // k = k % n;
        // int[] rotate = new int[n];

        // for (int i = 0; i < n; i++) {
        // rotate[(i + k) % n] = nums[i];
        // }
        // for (int i = 0; i < n; i++) {
        // nums[i] = rotate[i];
        // }
        // ---- 用額外O(n) space
        // 另外的想法是找到要 rotate 的那個點，先全部reverse之後，再用rotate 的位置分別
        // 對兩個切過的 array 去做 reverse
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}