package strings;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "acbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.isEmpty()) return true;
        if (t.length() < s.length()) return false;
        int i = 0, j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else i++;
            if (j == s.length()) return true;
        }
        return false;
    }
}
