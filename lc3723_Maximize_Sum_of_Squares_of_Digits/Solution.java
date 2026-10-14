package lc3723_Maximize_Sum_of_Squares_of_Digits;

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // num 代表數字 n 可以有num個位數
        // sum 代表 digit1...digitnum 的總和
        // int[] n = new int[num];
        if (sum > 9 * num)
            return "";
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int digit = Math.min(sum, 9);
            result.append(digit);
            sum -= digit;
            num--;
        }

        return sum == 0 ? result.toString() : "";

    }

    void main() {
        IO.println(maxSumOfSquares(2, 3));
        IO.println(maxSumOfSquares(2, 17));
        IO.println(maxSumOfSquares(1, 10));
    }
}