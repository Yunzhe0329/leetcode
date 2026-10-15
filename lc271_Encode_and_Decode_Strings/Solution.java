package lc271_Encode_and_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append('#').append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int l = 0;
        while (l < str.length()) {
            int r = l;
            while (str.charAt(r) != '#') {
                r++;
            }
            int s_len = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r = l + s_len;
            result.add(str.substring(l, r));
            l = r;
        }
        return result;
    }

    void main() {
        List<String> strs1 = List.of("Hello", "World");
        String s1 = "5#Hello5#World";
        IO.println(encode(strs1));
        IO.println(decode(s1));
    }
}
