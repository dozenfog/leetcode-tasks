package strings;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.strip();
        String[] strings = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            res.append(strings[i]).append(" ");
        }
        return res.toString().strip();
    }
}
