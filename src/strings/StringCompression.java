package strings;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c'}));
    }

    public static int compress(char[] chars) {
        if (chars.length < 2) return chars.length;
        int curCount = 1, j = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[j] = chars[i - 1];
                if (curCount == 1) {
                    j++;
                } else if (curCount < 10) {
                    chars[j + 1] = (char) (curCount + 48);
                    j += 2;
                } else {
                    int k = 1;
                    while (curCount / (int) Math.pow(10, k) != 0) {
                        k++;
                    }
                    int l = 1;
                    while (k > 0) {
                        chars[j + l] = (char) (curCount / (int) Math.pow(10, k - 1) + 48);
                        curCount %= (int) Math.pow(10, k - 1);
                        k--;
                        l++;
                    }
                    j += l;
                }
                curCount = 1;
            } else curCount++;
        }
        return j;
    }
}
