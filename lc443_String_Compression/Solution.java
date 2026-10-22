package lc443_String_Compression;

class Solution {

    public int compress(char[] chars) {
        // char[i] is a lowercase
        // English letter, uppercase English letter, digit, or symbol.
        int n = chars.length;
        int idx = 0;
        int i = 0;
        while (i < n) {
            char c = chars[i];
            int counter = 0;

            while (i < n && chars[i] == c) {
                counter++;
                i++;
            }
            if (counter == 1) {
                chars[idx++] = c;
            } else {
                chars[idx++] = c;
                // 2 - n
                for (char digit : Integer.toString(counter).toCharArray()) {
                    chars[idx++] = digit;
                }
            }
        }
        return idx;
    }

}