package lc1752_Check_If_Array_Is_Sorted_and_Rotated;

class Solution {
    public boolean check(int[] nums) {
        // check if an array sorted and rotated
        // soted 的情況 : nums[i] <= nums[i+1]
        // sorted 的情況下如果可以 rotate
        // rotate 後的 array 會是兩個排序的 array，因此，只會有在邊界的時候，會呈現逆序
        // [1, 2, 3, 4 , 5] -> rotate right by 2 -> 4 ,5 , 1, 2, 3
        // 理論上 nums[i] <= nums[i+1]，在 5, 1 之間會有一個錯，其餘都要符合
        int n = nums.length;
        boolean fault = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (fault)
                    return false;
                fault = true;
            }
        }
        return true;

    }

    void main() {
        int[] nums1 = { 4, 5, 1, 2, 3 }; // true
        IO.println(check(nums1));
        int[] nums2 = { 4, 5, 2, 1, 3 }; // fasle
        IO.println(check(nums2));
    }
}