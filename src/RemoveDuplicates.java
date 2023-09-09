import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates2(nums) + " " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 1, k = 1;
        if (nums.length <= 1) return nums.length;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
                continue;
            } else if (j > i + 1) {
                nums[i + 1] = nums[j];
            }
            i++;
            j++;
            k++;
        }
        return k;
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 1, j = 2, k = 2;
        if (nums.length <= 2) return nums.length;
        while (j < nums.length) {
            if (nums[i] == nums[i - 1] && nums[j] == nums[i]) {
                j++;
                continue;
            } else if (nums[i] != nums[i - 1] || nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
            }
            i++;
            j++;
            k++;
        }
        return k;
    }
}