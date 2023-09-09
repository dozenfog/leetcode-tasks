import java.util.Arrays;

public class Citations {
    public static void main(String[] args) {
        int[] citations = {0,0};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        if (citations.length == 1) return citations[0] >= 1 ? 1 : 0;
        Arrays.sort(citations);
        int i = 0;
        while (citations[i] < citations.length - i) {
            i++;
            if (i == citations.length) {
                return 0;
            }
        }
        return citations.length - i;
    }
}
