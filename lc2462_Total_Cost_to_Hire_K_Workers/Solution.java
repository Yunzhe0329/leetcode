package lc2462_Total_Cost_to_Hire_K_Workers;

import java.util.*;

// LeetCode 2462. Total Cost to Hire K Workers
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
        long cost = 0;
        int left = 0;
        int right = costs.length - 1;

        while (k-- > 0) {
            while (leftMinHeap.size() < candidates && left <= right) {
                leftMinHeap.offer(costs[left]);
                left++;
            }
            while (rightMinHeap.size() < candidates && left <= right) {
                rightMinHeap.offer(costs[right]);
                right--;
            }
            int ca1 = leftMinHeap.size() > 0 ? leftMinHeap.peek() : Integer.MAX_VALUE;
            int ca2 = rightMinHeap.size() > 0 ? rightMinHeap.peek() : Integer.MAX_VALUE;

            if (ca1 <= ca2) {
                cost += ca1;
                leftMinHeap.poll();
            } else {
                cost += ca2;
                rightMinHeap.poll();
            }
        }

        return cost;
    }
}
