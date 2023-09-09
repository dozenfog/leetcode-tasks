package strings;

public class LastWord {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        char[] chars = s.strip().toCharArray();
        int j = chars.length - 1, counter = 0;
        while (j >= 0 && chars[j] != ' ') {
            counter++;
            j--;
        }
        return counter;
    }
}
