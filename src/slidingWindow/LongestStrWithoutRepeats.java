package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestStrWithoutRepeats {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.isEmpty()) return s.length();
        int i = 0, j = 1, len = 0;
        Map<Character, Integer> letters = new HashMap<>();
        letters.put(s.charAt(0), 0);
        while (j != s.length()) {
            if (letters.get(s.charAt(j)) != null && letters.get(s.charAt(j)) >= i) {
                if (len < (j - i)) len = j - i;
                i = letters.get(s.charAt(j)) + 1;
                letters.put(s.charAt(j), j);
            } else {
                letters.put(s.charAt(j), j);
            }
            j++;
        }
        return Math.max(len, j - i);
    }
}
