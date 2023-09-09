public class MaxSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }
        if (max < 0) return max;
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(0, curSum + num);
            if (curSum > maxSum) maxSum = curSum;
        }
        return maxSum;
    }
}
