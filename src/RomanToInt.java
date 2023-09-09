public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'C') {
                if (i < s.length() - 1 && (chars[i + 1] == 'M' || chars[i + 1] == 'D')) res -= 100;
                else res += 100;
            } else if (chars[i] == 'M') res += 1000;
            else if (chars[i] == 'D') res += 500;

            if (chars[i] == 'X') {
                if (i < s.length() - 1 && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) res -= 10;
                else res += 10;
            } else if (chars[i] == 'L') res += 50;

            if (chars[i] == 'I') {
                if (i < s.length() - 1 && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) res--;
                else res++;
            } else if (chars[i] == 'V') res += 5;
        }
        return res;
    }
}
