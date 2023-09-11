package hashMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map1.put(word2.charAt(i), map1.getOrDefault(word2.charAt(i), 0) + 1);
        }
        return map.keySet().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(""))
                .concat(map.values().stream().sorted().map(String::valueOf)
                        .collect(Collectors.joining(""))
                )
                .equals(map1.keySet().stream()
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining(""))
                        .concat(map1.values().stream().sorted().map(String::valueOf)
                                .collect(Collectors.joining(""))
                        ));
    }
}
