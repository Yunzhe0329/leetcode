package lc735_Asteriod_Collision;

import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for (int ast : asteroids) {
            if (ast > 0) {
                stk.push(ast);
            } else {
                while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < -ast) {
                    stk.pop();
                }
                if (stk.isEmpty() || stk.peek() < 0) {
                    stk.push(ast);
                }
                if (stk.peek() == -ast) {
                    stk.pop();
                }
            }
        }

        int[] result = new int[stk.size()];
        int idx = stk.size() - 1;

        while (!stk.isEmpty()) {
            result[idx--] = stk.pop();
        }

        return result;

    }

    void main() {
        int[] asteroids = { 5, 10, -5 };
        IO.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}