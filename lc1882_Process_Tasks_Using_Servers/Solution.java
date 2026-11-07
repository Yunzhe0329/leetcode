package lc1882_Process_Tasks_Using_Servers;

import java.util.*;

// LeetCode 1882. Process Tasks Using Servers
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = servers.length;
        int n = tasks.length;
        int[] result = new int[n];

        PriorityQueue<int[]> availableServers = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < m; i++) {
            availableServers.offer(new int[] { i, servers[i] }); // [serverId, weight]
        }
        // [serverId, freeTime, weight]
        // 在 t 秒時，可能有多台server 被釋放，如果沒有用 server weight 去排，任務會按照釋放的順序被 assign ，會破壞 rule

        /*
         * If there are no free servers and the queue is not empty, we wait until a
         * server becomes free and immediately assign the next task. If multiple servers
         * become free at the same time, then multiple tasks from the queue will be
         * assigned in order of insertion following the weight and index priorities
         * above.
         */
        PriorityQueue<long[]> unavailableServers = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return Long.compare(a[1], b[1]); // 先比free time
            if (a[2] != b[2]) {
                return Long.compare(a[2], b[2]); // free time 相同時，再比 weight
            }
            return Long.compare(a[0], b[0]);
        });
        for (int i = 0; i < n; i++) {
            // 確認 t 秒時，有沒有 server 會 free 出來
            while (!unavailableServers.isEmpty() && unavailableServers.peek()[1] <= i) {
                long[] pair = unavailableServers.poll();
                availableServers.offer(new int[] { (int) pair[0], (int) pair[2] });
            }
            // t 秒時，有 free 的 server -> assign 任務給 server
            if (!availableServers.isEmpty()) {
                int[] assignServer = availableServers.poll();
                result[i] = assignServer[0];
                unavailableServers
                        .offer(new long[] { (long) assignServer[0], (long) (i + tasks[i]), (long) assignServer[1] });
            } else {
                long[] assignServer = unavailableServers.poll();
                result[i] = (int) assignServer[0];
                unavailableServers.offer(
                        new long[] { (long) assignServer[0], (long) (assignServer[1] + tasks[i]), assignServer[2] });
            }

        }
        return result;
    }
}
