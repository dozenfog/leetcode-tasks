import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum1(new int[]{0,4,3,0}, 90)));
    }

    //in a sorted array
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        while (i != numbers.length) {
            int i1 = binSearch(numbers, target - numbers[i], i + 1, numbers.length);
            if (i1 == -1) i++;
            else return new int[]{i + 1, i1 + 1};
        }
        return new int[]{-1, -1};
    }

    public static int binSearch(int[] numbers, int target, int low, int high) {
        int mid = low + (high - low) / 2;

        if (high <= low) return -1;
        if (numbers[mid] == target) return mid;
        else if (numbers[mid] < target) return binSearch(numbers, target, mid + 1, high);
        else return binSearch(numbers, target, low, mid);
    }

    //in non-sorted array
    public static int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else return new int[]{map.get(target - numbers[i]), i};
        }
        return new int[]{-1, -1};
    }
}
