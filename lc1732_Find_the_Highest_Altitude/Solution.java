package lc1732_Find_the_Highest_Altitude;

class Solution{
    public int largestAltitude(int[] gain) {
        int altitude = 0; // init
        int highest = 0;
        
        for(int i = 0; i < gain.length; i++){
            if(gain[i] > altitude){
                altitude += gain[i];
                highest = Math.max(highest, altitude);
            }
        }
        return highest;
        
    }
}
