package lc875_Koko_Eating_Bananas;

// LeetCode 875. Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // piles.length <= h -> or koko can't eat all piles of banana
        int n = piles.length;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, piles[i]);
        }
        int l = 1;
        int r = mx;
        int result = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            long count = 0;
            for (int p : piles) {
                count += p / k;
                if (p % k != 0) {
                    count++;
                }
            }
            if (count <= h) {
                result = Math.min(result, k);
                r = k - 1;
            } else {
                l = k + 1;
            }

        }
        return result;

    }
}
