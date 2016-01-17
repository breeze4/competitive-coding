package leetcode;

import org.junit.Assert;

public class ZigZag {

    public static void main(String[] args) {
        ZigZag zg = new ZigZag();
        System.out.println("actual: " + zg.convert("PAYPALISHIRING", 3));
        System.out.println("expected: " + "PAHNAPLSIIGYIR");
        System.out.println("actual: " + zg.convert("AB", 1));
        System.out.println("expected: " + "AB");
        System.out.println("actual: " + zg.convert("ABC", 2));
        System.out.println("expected: " + "ACB");
    }

    public String convert(String str, int rows) {
        if(rows == 1) {
            return str;
        }
        char[] in = str.toCharArray();
        StringBuilder out = new StringBuilder();

        int p;
        for (int i = 0; i < rows; i++) {
            p = i;
            while (p < in.length) {
                out.append(in[p]);
                p = i == 1 ? p + rows - 1 : p + rows + 1;
            }
        }

        return out.toString();
    }
}
