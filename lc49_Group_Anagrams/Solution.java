package lc49_Group_Anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // 如果目前 s 在 map 中沒有對應到的 key -> 代表是 new word
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

    void main() {
        List<String> strs1 = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        IO.println(groupAnagrams(strs1));

        List<String> strs2 = List.of("");
        IO.println(groupAnagrams(strs2));

        List<String> strs3 = List.of("a");
        IO.println(groupAnagrams(strs3));
    }
}