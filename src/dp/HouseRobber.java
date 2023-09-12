package dp;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1}));
    }

    public static int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = (nums.length > 2) ? nums[2] + dp[0] : dp[0];
        for (int i = 3; i < dp.length; i++) {
            int max = Math.max(dp[i - 3], dp[i - 2]);
            if (i == dp.length - 1) dp[i] = max;
            else dp[i] = max + nums[i];
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }
}
