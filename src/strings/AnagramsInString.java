package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("acdcaeccde", "c"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return new ArrayList<>();
        if (p.length() == 1 && s.length() == 1 && s.charAt(0) == p.charAt(0)) return List.of(0);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int i = 0, j = 0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))) {
                while (i < j) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    i++;
                }
                i++;
                j = i;
                continue;
            }
            if (map.get(s.charAt(j)) == 0) {
                while (s.charAt(i) != s.charAt(j)) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    i++;
                }
                i++;
                j++;
                continue;
            }
            if (map.get(s.charAt(j)) == 1 && j - i + 1 == p.length()) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                res.add(i);
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                i++;
            } else map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            j++;
        }
        return res;
    }
}
