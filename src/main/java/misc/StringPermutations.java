package misc;

public class StringPermutations {

    public static void main(String[] args) {
        permutations("a");
        permutations("ab");
        permutations("abc");
    }

    public static void permutations(String str) {
        printPerms(str, "", str.length());
    }

    private static void printPerms(String src, String out, int max) {
        if (out.length() == max) {
            System.out.println(out);
        } else {
            for (int i = 0; i < src.length(); i++) {
                String appended = out + src.substring(i, i + 1);
                printPerms(src.substring(0, i) + src.substring(i + 1, src.length()), appended, max);
            }
        }
    }
}
