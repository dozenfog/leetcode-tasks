public class IntToRoman {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        s.append("M".repeat(num / 1000));
        int resHundred = num % 1000 / 100, resTen = num % 100 / 10, res = num % 10;
        if (resHundred < 4) s.append("C".repeat(resHundred));
        else if (resHundred == 4) s.append("CD");
        else if (resHundred < 9) s.append("D").append("C".repeat(resHundred - 5));
        else s.append("CM");

        if (resTen < 4) s.append("X".repeat(resTen));
        else if (resTen == 4) s.append("XL");
        else if (resTen < 9) s.append("L").append("X".repeat(resTen - 5));
        else s.append("XC");

        if (res < 4) s.append("I".repeat(res));
        else if (res == 4) s.append("IV");
        else if (res < 9) s.append("V").append("I".repeat(res - 5));
        else s.append("IX");
        return s.toString();
    }
}
