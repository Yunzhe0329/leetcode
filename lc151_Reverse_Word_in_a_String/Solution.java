package lc151_Reverse_Word_in_a_String;

class Solution {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // 先壓縮多餘的空格: word1_word2_..._wordn
        // m 是壓縮原本字串之後的字串長度
        int m = compress(arr, n);

        // 全部 reverse
        reverse(arr, 0, m - 1);

        // 逐字 reverse
        return reverseWords(arr, m);
    }

    private int compress(char[] arr, int n) {
        // 用 r 掃描過 char array，用 l 來改寫成壓縮後的array
        int l = 0;
        int r = 0;

        while (r < n) {
            while (r < n && arr[r] == ' ') {
                r++;
            }
            while (r < n && arr[r] != ' ') {
                arr[l++] = arr[r++];
            }
            while (r < n && arr[r] == ' ') {
                r++;
            }
            if (r < n) {
                arr[l++] = ' ';
            }
        }
        return l;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    private String reverseWords(char[] arr, int n) {
        int l = 0;
        int r = 0;

        while (r < n) {
            while (r < n && arr[r] != ' ') {
                r++;
            }
            reverse(arr, l, r - 1);
            l = r + 1;
            r++;
        }

        return new String(arr, 0, n);
    }

}