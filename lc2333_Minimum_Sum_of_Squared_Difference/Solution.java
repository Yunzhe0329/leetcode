package lc2333_Minimum_Sum_of_Squared_Difference;
// import java.util.*;
class Solution{
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2){
        int n = nums1.length;
        // 1 <= n <= 10^5
        int[] d = new int[100001];
        long k = (long)(k1+k2); // +1 or -1 是等價的操作，都是要讓 diff 變小，所以可以視為整個 d 可以做幾次調整
        int max_diff = 0;
        for(int i = 0; i < n; i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            d[diff]++;
            max_diff = Math.max(max_diff, diff);
        }
        
        for(int i = max_diff; i > 0 && k > 0; i--){
            int modify = (int)Math.min(d[i], k);
            d[i] -= modify;
            d[i-1] += modify;
            k -= modify;
        }
        
        long result = 0;
        for(int i = 1; i <= max_diff; i++){
            result += d[i]*i*i;
        }
        return result;

    }

    public static void main(String[] args){
        Solution sol = new Solution();
        // tc1
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{2,10,20,19};
        int k1 = 0, k2 = 0;

        // tc2
        int[] nums3 = new int[]{1, 4, 10, 12};
        int[] nums4 = new int[]{5,8,6,9};
        int k3 = 1, k4 = 1;

        System.out.println(sol.minSumSquareDiff(nums1, nums2, k1, k2)); // 579
        System.out.println(sol.minSumSquareDiff(nums3, nums4, k3, k4)); // 43
    }
}