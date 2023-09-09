package strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            letters.put(magazine.charAt(i), letters.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (letters.get(ransomNote.charAt(i)) == null || letters.get(ransomNote.charAt(i)) == 0) return false;
            letters.put(ransomNote.charAt(i), letters.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }
}
