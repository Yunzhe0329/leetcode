package lc134_Gas_Station;

// LeetCode 134. Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        int result = 0;
        int tank = 0;
        for (int i = 0; i < gas.length - 1; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                result = i + 1;
            }
        }
        return result;
    }
}
