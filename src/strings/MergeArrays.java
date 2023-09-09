package strings;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        //merge sorted arrays
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else if (n == 0) return;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[i + j + 1] = nums2[j];
                j--;
            } else {
                nums1[i + j + 1] = nums1[i];
                i--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }
}