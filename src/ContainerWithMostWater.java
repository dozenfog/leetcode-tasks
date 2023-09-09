public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println((maxArea(new int[]{1, 2, 4, 3})));
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, curArea = (j - i) * Math.min(height[i], height[j]);
        while (i + 1 < j) {
            if (height[i] > height[j]) {
                do {
                    j--;
                } while (height[j] < height[i] && height[j] <= height[j + 1]);
            } else {
                do {
                    i++;
                } while (height[i] < height[j] && height[i] <= height[i - 1]);
            }
            if (i == j) return curArea;
            if (curArea < (j - i) * Math.min(height[i], height[j])) curArea = (j - i) * Math.min(height[i], height[j]);
        }
        return curArea;
    }
}
