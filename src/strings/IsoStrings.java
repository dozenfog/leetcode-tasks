package strings;

import java.util.HashMap;
import java.util.Map;

public class IsoStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "bapo"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters.get(s.charAt(i)) == null && letters.containsValue(t.charAt(i))) {
                return false;
            }
            int finalI = i;
            letters.computeIfAbsent(s.charAt(i), k -> t.charAt(finalI));
            if (letters.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
