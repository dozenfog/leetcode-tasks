import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1, -100};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if (nums.length == 1 || k == 0) return;
        for (int i = 0; i <= (nums.length - k - 1) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - k - 1 - i];
            nums[nums.length - k - 1 - i] = temp;
        }
        for (int i = 0; i <= (k - 1) / 2; i++) {
            int temp = nums[nums.length - k + i];
            nums[nums.length - k + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
