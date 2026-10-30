package lc933_Number_of_Recent_Calls;

import java.util.*;

class RecentCounter {
    Queue<Integer> q = new ArrayDeque<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }

        return q.size();
    }
}
