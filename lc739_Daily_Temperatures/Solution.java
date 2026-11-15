package lc739_Daily_Temperatures;

// LeetCode 739. Daily Temperatures
import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // double head queue -> better performance said in Java docs
        Deque<Integer> stack = new ArrayDeque<>(n);
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return result;
    }
}
