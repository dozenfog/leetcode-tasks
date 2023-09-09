package strings;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"", "tea"}));
    }

    //can be solved sorting chars in words & putting into map then grouping words as anagrams to sorted words in map. then get values as list of lists
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) return List.of(List.of(strs[0]));

        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        cur.add(strs[0]);
        int i = 0, j = 1, strsSize = strs.length;
        while (i < strsSize - 1) {
            while (isAnagram(strs[i], strs[j]) && j < strsSize) {
                cur.add(strs[j]);
                strs[j] = strs[strsSize - 1];
                strsSize--;
            }
            j++;
            if (j >= strsSize) {
                if (cur.isEmpty()) res.add(List.of(strs[i]));
                else {
                    res.add(cur.stream().toList());
                    cur.clear();
                }
                i++;
                j = i + 1;
                if (i < strsSize) cur.add(strs[i]);
            }
        }
        if (!cur.isEmpty()) res.add(cur);
        return res;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.get(t.charAt(i)) == null || map.get(t.charAt(i)) == 0) return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        return true;
    }
}
