package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {2, 3}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int[] curArr = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (curArr[1] >= intervals[i][0]) {
                curArr = new int[]{curArr[0], Math.max(intervals[i][1], curArr[1])};
            } else {
                res.add(curArr);
                curArr = intervals[i];
            }
        }
        res.add(curArr);
        return res.toArray(new int[][]{});
    }
}
