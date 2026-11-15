package lc901_Online_Stock_Span;

import java.util.*;

// LeetCode 901. Online Stock Span
class StockSpanner {
    private Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();

    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price > stack.peek()[0]) {
            count += stack.pop()[1];
        }
        stack.push(new int[] { price, count });
        return count;
    }
}
