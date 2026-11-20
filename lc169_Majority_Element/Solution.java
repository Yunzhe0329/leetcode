package lc169_Majority_Element;

// LeetCode 169. Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            count += num == result ? 1 : -1;
        }
        return result;
    }
}
/*
 *  Boyer-Moore 投票演算法
 *  必須條件:這個演算法只保證：如果有元素出現超過 n/2 次，最後留下的 result 一定是它
 *
 *  每次 count -1，就是一個 result 和一個不同的元素互相抵掉。
 *  多數元素的數量比其他所有元素加起來還多，
 *  就算其他元素全部拿來抵它，抵不完，所以最後一定會留下它
 *
 *
 **/
