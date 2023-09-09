package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{-1, 1})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval.length == 0) return intervals;
        List<List<Integer>> intervalsList = new ArrayList<>(Arrays.stream(intervals).map(l -> Arrays.stream(l).boxed().toList()).toList());
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[0][0]) {
                intervalsList.add(0, Arrays.stream(newInterval).boxed().toList());
                break;
            }
            if (newInterval[0] >= intervals[intervals.length - 1][0]) {
                intervalsList.add(Arrays.stream(newInterval).boxed().toList());
                break;
            }
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i + 1][0]) {
                intervalsList.add(i + 1, Arrays.stream(newInterval).boxed().toList());
                break;
            }
        }
        List<Integer> curArr = intervalsList.get(0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < intervalsList.size(); i++) {
            if (curArr.get(1) >= intervalsList.get(i).get(0)) {
                curArr = List.of(curArr.get(0), Math.max(intervalsList.get(i).get(1), curArr.get(1)));
            } else {
                res.add(curArr);
                curArr = intervalsList.get(i);
            }
        }
        res.add(curArr);
        return res.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
