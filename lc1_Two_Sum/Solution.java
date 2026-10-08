package lc1_Two_Sum;

import java.util.*;
class Solution{
    public int[] twoSum(int[] nums, int target){
        // 給你一個整數 arr
        // 找出兩個整數合 = target，並回傳他們的 idx
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(mp.containsKey(complement)){
                return new int[]{mp.get(complement), i};
            }
            mp.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        // TC
        int[] tc1 = new int[]{2,7,11,15};
        int tc1_target = 9;

        int[] tc2 = new int[]{3, 2, 4};
        int tc2_target = 6;

        int[] tc3 = new int[]{3,3};
        int tc3_target = 6;

        System.out.println(Arrays.toString(sol.twoSum(tc1, tc1_target))); // [0, 1]
        System.out.println(Arrays.toString(sol.twoSum(tc2, tc2_target))); // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(tc3, tc3_target))); // [0, 1]
    }
}