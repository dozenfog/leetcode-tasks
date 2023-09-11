package slidingWindow;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 1, 1, 0}, 1));
    }

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, curK = k, cur = 0;
        while (j < nums.length) {
            if (nums[j] == 1 || (nums[j] == 0 && curK > 0)) {
                if (nums[j] != 1)
                    curK--;
                j++;
            } else if (cur < j - i)
                cur = j - i;
            else {
                if (nums[i] == 1) {
                    while (nums[i] != 1 || nums[i + 1] != 0) i++;
                    i++;
                    int countZeroes = 0;
                    while (i < nums.length && nums[i] == 0) {
                        countZeroes++;
                        i++;
                    }
                    i = (i - Math.min(countZeroes, k));
                } else {
                    if (nums[i] == 0) {
                        i++;
                    }
                }
                curK = k;
                j = i;
            }
        }
        if (cur < j - i)
            cur = j - i;
        return cur;
    }
}
