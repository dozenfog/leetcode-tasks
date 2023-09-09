package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BurstingBalloons {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 5}, {5, 7}, {3, 6}}));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(i -> i[0]));
        int[] curArr = points[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < points.length; i++) {
            if (curArr[1] >= points[i][0]) {
                curArr = new int[]{points[i][0], Math.min(points[i][1], curArr[1])};
            } else {
                res.add(curArr);
                curArr = points[i];
            }
        }
        res.add(curArr);
        return res.size();
    }
}
