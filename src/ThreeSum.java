import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int index = binSearch(nums, -(nums[i] + nums[j]), 0, nums.length);
                if (index != -1 && index != i && index != j) {
                    Integer[] triple ={nums[i], nums[j], nums[index]};
                    Arrays.sort(triple);
                    res.add(Arrays.asList(triple));
                }
            }
        }
        return res.stream().toList();
    }

    public static int binSearch(int[] numbers, int target, int low, int high) {
        int mid = low + (high - low) / 2;

        if (high <= low) return -1;
        if (numbers[mid] == target) return mid;
        else if (numbers[mid] < target) return binSearch(numbers, target, mid + 1, high);
        else return binSearch(numbers, target, low, mid);
    }
}
