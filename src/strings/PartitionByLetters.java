package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionByLetters {
    public static void main(String[] args) {
        System.out.println(partitionLabels("accac"));
    }

    public static List<Integer> partitionLabels(String s) {
        if (s.length() == 1) return List.of(s.length());
        List<Integer> nums = new ArrayList<>();
        Map<Character, Integer> letters = new HashMap<>();
        for (int k = 0; k < s.length(); k++) {
            letters.put(s.charAt(k), k);
        }
        int max = 0, prev = -1;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, letters.get(s.charAt(i)));
            if (max == i) {
                nums.add(max - prev);
                prev = max;
            }
        }
        return nums;
    }
}
