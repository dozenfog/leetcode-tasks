package intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return List.of(Integer.toString(nums[0]));
        List<String> res = new ArrayList<>();
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (prev != i - 1) {
                    res.add(nums[prev] + "->" + nums[i - 1]);
                } else res.add(Integer.toString(nums[prev]));
                prev = i;
            }
        }
        if (prev != nums.length - 1) {
            res.add(nums[prev] + "->" + nums[nums.length - 1]);
        } else res.add(Integer.toString(nums[prev]));
        return res;
    }
}
