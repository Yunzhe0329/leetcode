package lc1004_Max_Consecutive_Ones_III;

//import java.util.*;

class Solution{
    public int longestOnes(int[] nums, int k) {
        // <k means how many times you can flip 0 to 1 to make the substring more longer
        // nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2;
        int n = nums.length;
        int l = 0;
        int result = 0;
        int windowZeros = 0;

        for(int r = l; r < n; r++){
            if(nums[r] == 0){
                windowZeros++;
            }
            while(windowZeros > k){
                if(nums[l] == 0){
                    windowZeros--;
                }
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
            
        return result; 

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(sol.longestOnes(nums, 2));
        System.out.println(sol.longestOnes(nums1, 3));
    }
}