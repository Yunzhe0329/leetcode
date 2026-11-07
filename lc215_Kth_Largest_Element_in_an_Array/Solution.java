package lc215_Kth_Largest_Element_in_an_Array;

import java.util.*;

// LeetCode 215. Kth Largest Element in an Array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
