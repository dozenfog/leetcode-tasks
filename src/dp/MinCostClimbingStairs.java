package dp;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            int min = Math.min(dp[i - 1], dp[i - 2]);
            if (i == dp.length - 1) dp[i] = min;
            else dp[i] = min + cost[i];
        }
        return dp[cost.length];
    }
}
