package lc1431_Kids_With_the_Greatest_Number_of_Candies;

import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int curr_max = 0;
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            curr_max = Math.max(curr_max, candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            boolean greatest = candies[i] + extraCandies >= curr_max;
            result.add(greatest);
        }

        return result;
    }
}