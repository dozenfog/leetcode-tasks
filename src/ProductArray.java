import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != nums.length - 1) {
                suffix *= nums[i + 1];
            }
            if (i != 0) {
                res[i] = res[i - 1] * suffix;
            } else res[i] = suffix;
        }
        return res;
    }
}
