public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {4, 5, 4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        int n = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == n) count++;
            else {
                count--;
                if (count == 0) {
                    n = nums[i];
                    count = 1;
                }
            }
        }
        return n;
    }
}
