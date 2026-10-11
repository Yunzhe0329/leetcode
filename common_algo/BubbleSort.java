package common_algo;

import java.util.*;

/*
從第一個元素開始，比較相鄰元素大小，如果順序有誤，則對調再進行下一個元素的比較。
掃描過一次後就可以確保最後一個元素是位於正確的位置。接著再進行第二次掃描，
直到所有元素完成排序為止

Base case : O(n) -> is already a sorted array

Worst case : O(n^2) -> is a decreasing-order array

Average case : O(n^2)



*/
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