package lc2336_Smallest_Number_in_Infinite_Set;

import java.util.*;

// LeetCode 2336. Smallest Number in Infinite Set
class SmallestInfiniteSet {
    private PriorityQueue<Integer> minHeap;
    private int currMin;
    private Set<Integer> addNumber;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        currMin = 1;
        addNumber = new HashSet<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addNumber.remove(smallest);
            return smallest;
        }
        return currMin++;
    }

    public void addBack(int num) {
        if (num < currMin && !addNumber.contains(num)) {
            minHeap.offer(num);
            addNumber.add(num);
        }
    }
}