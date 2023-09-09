package strings;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < Math.min(strs[i].length(), strs[0].length()); j++) {
                if (strs[i].toCharArray()[j] == strs[0].toCharArray()[j]) str.append(strs[0].toCharArray()[j]);
                else break;
            }
            if (str.toString().length() < res.length()) res = str.toString();
        }
        return res;
    }
}
