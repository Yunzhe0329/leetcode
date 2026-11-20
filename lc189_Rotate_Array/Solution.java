package lc189_Rotate_Array;

class Solution {
    public void rotate(int[] nums, int k) {
        int rotateIdx = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotateIdx - 1);
        reverse(nums, rotateIdx, nums.length - 1);
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
