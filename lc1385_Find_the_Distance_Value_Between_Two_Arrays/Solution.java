package lc1385_Find_the_Distance_Value_Between_Two_Arrays;

// LeetCode 1385. Find the Distance Value Between Two Arrays
import java.util.*;

class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // int idx = 0;
        // int result = 0;
        // while (idx < arr1.length) {
        // boolean valid = true;
        // for (int j = 0; j < arr2.length; j++) {
        // if (Math.abs(arr1[idx] - arr2[j]) <= d) {
        // valid = false;
        // break;
        // }
        // }
        // if (valid) {
        // result++;
        // }
        // idx++;
        // }

        // return result
        int result = 0;
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (inRange(arr2, arr1[i] - d, arr1[i] + d)) {
                continue;
            } else {
                result++;
            }
        }
        return result;

    }

    private boolean inRange(int[] arr, int start, int end) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + (r - l)) / 2;
            if (arr[mid] >= start && arr[mid] <= end) {
                return true;
            } else if (arr[mid] > start) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
