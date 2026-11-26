// LeetCode 6. Zigzag Conversion

import java.util.*;

class Solution {
    public String convert(String s, int numRows){
        if(numRows == 1 || numRows > s.length()){
            return s;
        }
        List<Character>[] zigzag = new ArrayList<>[numRows];
        for(int i = 0; i <numRows; i++){
            zigzag[i] = new ArrayList<>();
        }
        int idx = 0;
        int next = 1;
        for(char c: s.toCharArray()){
            zigzag[idx].add(c);
            if(idx == 0){
                next = 1;
            }

            if(idx == numRows - 1){
                next = -1;
            }
            idx += next;
        }

        StringBuilder result = new StringBuilder();
        for(List<Character> row: zigzag){
            for(char c: row){
                result.append(c);
            }
        }
        return result.toString();
    }
}
