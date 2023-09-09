import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3};
        int val = 3;
        System.out.println(removeElement(nums, val) + " " + Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) return 0;
            else return 1;
        }
        int k = 0, i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != val) {
                k++;
                i++;
                j++;
            } else if (nums[j] == val) j++;
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
                k++;
            }
        }
        return k;
    }
}