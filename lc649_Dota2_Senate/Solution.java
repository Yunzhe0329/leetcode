package lc649_Dota2_Senate;

import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }

        while (!rq.isEmpty() && !dq.isEmpty()) {
            int idxRadiant = rq.poll();
            int idxDire = dq.poll();
            if (idxRadiant < idxDire) {
                rq.offer(idxRadiant + senate.length());
            } else {
                dq.offer(idxDire + senate.length());
            }
        }

        return rq.size() > 0 ? "Radiant" : "Dire";
    }
}