package lc1606_Find_Servers_That_Handled_Most_Number_of_Requests;

import java.util.*;

// LeetCode 1606. Find Servers That Handled Most Number of Requests
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> availableServer = new PriorityQueue<>();
        // serverId, nextAvailableTime
        PriorityQueue<long[]> unavailableServer = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        int[] counter = new int[k];

        for (int i = 0; i < k; i++) {
            availableServer.add(i);
            // {0, 1, 2}
        }
        /*
         * 在第 i 個請求時，while loop 有執行就代表有 server 被釋放。先算 dist = ((id - i) % k + k) %
         * k，也就是從 i 往右繞到這台 server 的步數（0 到 k-1）。+k 是為了處理負數，最後的 %k 是把結果拉回 0 到 k-1。然後把 i +
         * dist 放進 heap，i + dist 就是這台 server 在數線上 ≥ i 的第一個位置
         */
        for (int i = 0; i < arrival.length; i++) {
            while (!unavailableServer.isEmpty() && unavailableServer.peek()[1] <= arrival[i]) {
                int id = (int) unavailableServer.poll()[0];
                availableServer.offer(i + ((id - i) % k + k) % k);
            }
            if (availableServer.isEmpty()) {
                continue;
            }
            int assignedId = availableServer.poll() % k;
            counter[assignedId]++;
            unavailableServer.offer(new long[] { assignedId, (long) arrival[i] + load[i] });
        }

        int mx = 0;
        for (int a : counter) {
            mx = Math.max(mx, a);
        }

        for (int i = 0; i < k; i++) {
            if (counter[i] == mx) {
                result.add(i);
            }
        }
        return result;

    }
}
