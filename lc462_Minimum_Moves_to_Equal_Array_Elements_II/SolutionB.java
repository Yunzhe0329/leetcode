// using quicksort
package lc462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.*;

class SolutionB {
    private final Random rand = new Random();

    public int minMoves2(int[] nums) {
        int result = 0;
        int median = quickselect(nums, nums.length / 2);
        for (int x : nums) {
            result += Math.abs(x - median);
        }
        return result;
    }

    private int quickselect(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (true) {
            int pivot = arr[low + rand.nextInt(high - low + 1)];
            int lt = low, i = low, gt = high;
            while (i <= gt) {
                if (arr[i] < pivot) {
                    swap(arr, lt++, i++);
                } else if (arr[i] > pivot) {
                    swap(arr, i, gt--);
                } else {
                    i++;
                }
            }
            if (k < lt) {
                high = lt - 1;
            } else if (k > gt) {
                low = gt + 1;
            } else {
                return pivot;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}