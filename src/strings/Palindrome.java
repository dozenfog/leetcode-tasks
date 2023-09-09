package strings;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab_a"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[\\W_]+", "");
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j) ||
                    (s.charAt(i) >= 65 && s.charAt(i) <= 122 && s.charAt(j) >= 65 && s.charAt(j) <= 122 &&
                            (s.charAt(i) + 32 == s.charAt(j) || s.charAt(i) - 32 == s.charAt(j)))) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
