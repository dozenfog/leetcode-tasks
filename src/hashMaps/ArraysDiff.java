package hashMaps;

import java.util.*;

public class ArraysDiff {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[] {1,1,2,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums1).boxed().toList());
        Set<Integer> set1 = new HashSet<>(Arrays.stream(nums2).boxed().toList());
        for (int num : nums2) {
            if (set.contains(num)) {
                set.remove(num);
                set1.remove(num);
            }
        }
        return List.of(set.stream().toList(), set1.stream().toList());
    }
}
