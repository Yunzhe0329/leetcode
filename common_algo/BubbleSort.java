package common_algo;

import java.util.*;

class BubbleSort {
    public int[] bubblesort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        BubbleSort bub = new BubbleSort();
        int[] nums1 = new int[] { 5, 1, 4, 2, 6 };
        int[] sorted = bub.bubblesort(nums1);
        System.out.println(Arrays.toString(sorted));
    }
}