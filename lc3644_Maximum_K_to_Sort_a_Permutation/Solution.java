package lc3644_Maximum_K_to_Sort_a_Permutation;



class Solution{

    public int sortPermutation(int[] nums) {
        // input = [0, 3, 2, 1]
        int n = nums.length;
        // -1 -> 2's complement -> 所有 bits 都是1
        // -1 & x = x
        int k = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                k &= nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args){

        Solution sol = new Solution();
        int[] nums = {0,3,2,1}; // 1
        System.out.println(sol.sortPermutation(nums));

    }
}