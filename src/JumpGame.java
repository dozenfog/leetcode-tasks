import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump1(nums));
    }

    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        if (nums.length == 1) return true;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) dp[i] = Math.max(dp[i - 1] - 1, nums[i - 1] - 1);
            else dp[i] = dp[i - 1];
        }
        return dp[nums.length - 1] >= 0;
    }

    public static int canJump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
