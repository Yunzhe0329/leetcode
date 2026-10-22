package lc33_Search_in_Rotated_Sorted_Array;

/**
 * Solution
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 給定的 nums is sorted and possibly with left rotate with k
        // [0,1,2,4,5,6,7]
        // left rotate 3 index -> [4,5,6,7,0,1,2]
        // 從給定的 array 中找到 target value index，沒找到 -1
        // time complexity - O(nlogn)

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // left portion : edge case 今天只有兩個元素，會處理不了
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target > nums[r] || target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;

    }

    void main() {
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        IO.println(search(nums1, target1));
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = 3;
        IO.println(search(nums2, target2));
        int[] nums3 = { 3, 1 };
        int target3 = 1;
        IO.println(search(nums3, target3));

        // 1 -> 1 <= 1 -> left portion，但 target > nums[mid] -> l = mid + 1;
        int[] nums4 = { 1, 3 };
        int target4 = 3;
        IO.println(search(nums4, target4));

    }
}