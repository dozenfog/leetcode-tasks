package hashMaps;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, -8, 7, -2, -4, -4, 6, 3, -4, 0, -7, -1, 5, 1, -9, -3}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 1, k = 1, j = 0;
        for (int num : nums) {
            map.put(num, false);
        }
        while (j != nums.length) {
            if (!map.get(nums[j])) {
                if (map.containsKey(nums[j] - k) && !map.get(nums[j] - k) && map.containsKey(nums[j] + k) && !map.get(nums[j] + k)) {
                    j++;
                    continue;
                }
                while (map.get(nums[j] - k) != null && !map.get(nums[j] - k)) {
                    map.put(nums[j] - k, true);
                    k++;
                }
                if (k > res) res = k;
                k = 1;
                while (map.get(nums[j] + k) != null && !map.get(nums[j] + k)) {
                    map.put(nums[j] + k, true);
                    k++;
                }
                if (k > res) res = k;
                k = 1;
                map.put(nums[j], true);
            }
            j++;
        }
        return res;
    }
}
