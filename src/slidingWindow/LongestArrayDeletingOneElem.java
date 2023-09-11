package slidingWindow;

public class LongestArrayDeletingOneElem {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 1}));
    }

    public static int longestSubarray(int[] nums) {
        int i = 0, j = 0, res = 0, indexZero = -1;
        while (j < nums.length) {
            while (j < nums.length && (nums[j] == 1 || indexZero == -1)) {
                if (nums[j] == 0) indexZero = j;
                j++;
            }
            if (res < j - i) res = j - i;
            if (indexZero != -1 && j < nums.length) {
                i = indexZero + 1;
                j = i;
                indexZero = -1;
            } else return res - 1;
        }
        return res - 1;
    }
}
