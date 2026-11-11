package lc216_Combination_Sum_III;

import java.util.*;

// LeetCode 216. Combination Sum III
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;

    }

    private void backtrack(int start, int k, int target, List<Integer> comb, List<List<Integer>> list) {
        if (comb.size() == k && target == 0) {
            list.add(new ArrayList<>(comb));
            return;
        }
        if (comb.size() == k || target <= 0) {
            return;
        }

        for (int i = start; i <= Math.min(target, 9); i++) {
            comb.add(i);
            backtrack(i + 1, k, target - i, comb, list);
            comb.remove(comb.size() - 1);
        }

    }
}
