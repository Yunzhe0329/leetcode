// LeetCode 3360. Stone Removal Game

class Solution {
    public boolean canAliceWin(int n){
        if(n < 10){
            return false;
        }

        boolean alice = true;
        int remove = 10;

        while(n >= remove){
            n -= remove;
            remove--;
            alice = !alice;
        }

        return !alice;
    }
}
