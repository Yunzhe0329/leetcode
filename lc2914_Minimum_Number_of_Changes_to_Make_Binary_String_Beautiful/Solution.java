package lc2914_Minimum_Number_of_Changes_to_Make_Binary_String_Beautiful;
// LeetCode 2914. Minimum Number of Changes to Make Binary String Beautiful
class Solution {
	public int minChanges(String s){
    // given 0-indexed binary string s with even length;
    int result = 0;
    for(int i = 0; i < s.length(); i+=2){
      if(s.charAt(i) != s.charAt(i+1)){
        result++;
      }
    }
    return result;
	}
}
