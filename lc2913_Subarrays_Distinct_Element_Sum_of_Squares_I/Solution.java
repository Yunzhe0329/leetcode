package lc2913_Subarrays_Distinct_Element_Sum_of_Squares_I;

import java.util.*;

class Solution{
    public int sumCounts(List<Integer> nums) {
        // look for all possible subarrays in num
        // caculate distinct count = number of unique elements in that subarray.
        // nums[1, 2, 1]
        // subarrays
        // [1], [2], [1], [1, 2], [1, 2, 1], [2, 1]
        // brute force 去遍歷所有可能組合，每次都 new 一個 set
        int n = nums.size();
        int result = 0;
        for(int l = 0; l < n; l++){
            Set<Integer> distinct = new HashSet<>();
            for(int r = l; r < n; r++){
                distinct.add(nums.get(r));
                int count = distinct.size();
                result += count * count;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        List<Integer> nums1 = List.of(1, 2, 1);
        System.out.println(sol.sumCounts(nums1));
    }
}