package dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }

    // take diagonal if 1 else max of upper & left
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int k = 0; k < text2.length(); k++) {
                if (i == 0 && k == 0) grid[i][k] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
                else {
                    boolean equalChars = text1.charAt(i) == text2.charAt(k);
                    if (i == 0) grid[i][k] += (equalChars ? 1 : grid[i][k - 1]);
                    else if (k == 0) grid[i][k] += (equalChars ? 1 : grid[i - 1][k]);
                    else
                        grid[i][k] += (equalChars ? 1 + grid[i - 1][k - 1] : Math.max(grid[i - 1][k], grid[i][k - 1]));
                }
            }
        }
        return grid[text1.length() - 1][text2.length() - 1];
    }
}
