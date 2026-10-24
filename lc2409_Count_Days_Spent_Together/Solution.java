package lc2409_Count_Days_Spent_Together;

class Solution {
    static final int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int arriveA = helper(arriveAlice);
        int leaveA = helper(leaveAlice);
        int arriveB = helper(arriveBob);
        int leaveB = helper(leaveBob);

        int start = Math.max(arriveA, arriveB);
        int end = Math.min(leaveA, leaveB);

        return start >= end ? 0 : end - start + 1;
    }

    private int helper(String s) {
        int month = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int day = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        int result = day;
        for (int i = 0; i < month - 1; i++) {
            result += monthDays[i];
        }
        return result;
    }

    void main() {
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-16";
        IO.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)); // expect : 3
    }

}