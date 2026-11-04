package lc841_Keys_and_Rooms;

import java.util.*;

// LeetCode 841. Keys and Rooms
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        // since always start from room 0
        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int key : rooms.get(room)) {
                if (!visited.contains(key)) {
                    stack.push(key);
                    visited.add(key);
                    if (visited.size() == rooms.size()) {
                        return true;
                    }
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
