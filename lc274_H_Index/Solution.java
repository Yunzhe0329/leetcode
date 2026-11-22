package lc274_H_Index;

// LeetCode 274. H-Index
class Solution {
    public int hIndex(int[] citations) {
        // citation.length = total paper the researcher has released
        // citation[i] = number of the ith paper receive citations
        int n = citations.length;
        int[] bucket = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
