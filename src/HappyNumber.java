public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int[] pattern = new int[]{89, 145, 42, 20, 4};
        int i = 0;
        while (n != 1) {
            if (i == pattern.length) return false;
            int k = 0;
            while (n != 0) {
                k += (n % 10) * (n % 10);
                n /= 10;
            }
            if (k == pattern[i]) i++;
            n = k;
        }
        return true;
    }
}
