package lc151_Reverse_Words_in_a_String;

// LeetCode 151. Reverse Words in a String
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int m = compress(arr);

        reverse(arr, 0, m - 1);
        return reverseWord(arr, m);
    }

    private int compress(char[] arr) {
        int n = arr.length;
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

    private String reverseWord(char[] arr, int n) {
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
