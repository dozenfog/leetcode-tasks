package strings;

public class NeedleInHaystack {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int ih = 0, in = 0, previh = -1;

        while (ih != h.length && ih + in < h.length) {
            if (h[ih + in] == n[in]) {
                in++;
                if (in == n.length) return ih;
                if (ih + in < h.length && h[ih + in] == n[0] && previh == -1) {
                    previh = ih + in;
                }
            } else if (h[ih + in] != n[in]) {
                ih = previh == -1 ? ih + 1 : previh;
                in = 0;
                previh = -1;
            }
        }
        return -1;
    }
}
