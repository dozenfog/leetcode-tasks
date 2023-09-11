package hashMaps;

import java.util.*;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 1, 1}, 4));
    }

    public static int maxOperations(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        res = map.entrySet().stream().map(entry -> {
            if (map.containsKey(k - entry.getKey())) {
                return Math.min(entry.getValue(), map.get(k - entry.getKey()));
            }
            return 0;
        }).reduce(Integer::sum).orElse(0);
        return res / 2;
    }
}
