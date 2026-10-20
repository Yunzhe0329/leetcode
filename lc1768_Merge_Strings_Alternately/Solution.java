package lc1768_Merge_Strings_Alternately;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int max_length = Math.max(word1.length(), word2.length());

        for (int i = 0; i < max_length; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();

    }

    void main() {
        String s1 = "abc";
        String s2 = "pqr";

        IO.println(mergeAlternately(s1, s2));
    }
}