package lc3863_Minimu_Operation_To_Sort_A_String;

class Solution {
    public int minOperations(String s) {
        // first check if s is already be sorted
        int n = s.length();
        boolean isSorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            return 0;
        }
        // the substring cannot be the entire string, so if n == 2
        // not possible to do any sort e.g., s = "gf" return -1
        if (n == 2) {
            return -1;
        }

        int min = s.charAt(0), max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
            }
            if (s.charAt(i) > max) {
                max = s.charAt(i);
            }
        }

        // min : c, max : e
        // case1 恰好一個min與max其中一個就在頭或尾，排除那個位置排序一次
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }
        // case 2 min 或 max 有一份出現在中間 (1 ~ n-2)，
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }
        // case 3: s[0] 是唯一的 max，s[n-1] 是唯一的 min (例如 "edc")
        return 3;

    }

    void main() {
        String s1 = "edc"; // 3
        String s2 = "shopee"; // 2
        String s3 = "ardc"; // 1

        IO.println(minOperations(s1));
        IO.println(minOperations(s2));
        IO.println(minOperations(s3));
    }
}