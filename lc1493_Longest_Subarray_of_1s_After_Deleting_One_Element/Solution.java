package lc1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

class Solution{
    public int longestSubarray(int[] nums) {
        // you must delete 1 elements from the array
        // Return the size of the longest non-empty subarray containing only 1's in the resulting array.
        // Return 0 if there is no such subarray.
        int n = nums.length;
        int l = 0;
        int result = 0;
        int zeros = 0;
        for(int r = l; r < n; r++){
            if(nums[r] == 0){
                zeros++;
            }
            if(zeros > 1){
                if(nums[l] == 0){
                    zeros--;
                }
                l++;
            }
            result = Math.max(result, r - l);
        }
        
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {1,1,1};
        int[] nums2 = {0,1,1,1,0,1,1,0,1};
        System.out.println(sol.longestSubarray(nums));
        System.out.println(sol.longestSubarray(nums2));
    }
}