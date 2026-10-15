package lc15_3Sum;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        // 找到nums中，任一三個和為0的nums[idx1]、nums[idx2]、nums[idx3]
        // nums = [-1,0,1,2,-1,-4]
        // [[-1,-1,2],[-1,0,1]]
        // 用 sliding window 去 run 過在 index i 中會有幾種可能的組合(No duplicates)
        // 先排序 -> 如果起始的 index 已經是正數 -> 不可能找到
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // skip duplicate
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    void main() {
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        IO.println(threeSum(nums1));

        int[] nums2 = { 0, 1, 1 };
        IO.println(threeSum(nums2));

        int[] nums3 = { 0, 0, 0 };
        IO.println(threeSum(nums3));
    }
}