package epi;

import org.junit.Assert;

public class LevenshteinDistance {

    public static void main(String[] args) {
        Assert.assertEquals(8, levenshteinDistance("Carthorse".toCharArray(), "Orchestra".toCharArray()));
    }

    public static int levenshteinDistance(char[] a, char[] b) {
        if (a == null && b != null) return b.length;
        else if (a != null && b == null) return a.length;
        else if (a == null && b == null) return 0;

        int n = a.length;
        int m = b.length;
        int[][] result = new int[n + 1][m + 1];
        result[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            result[i][0] = i;

            for (int j = 1; j <= m; j++) {
                result[0][j] = j;

                if (a[j - 1] == b[i - 1])
                    result[i][j] = result[i - 1][j - 1];
                else
                    result[i][j] = min(result[i - 1][j], result[i - 1][j - 1], result[i][j - 1]) + 1;
            }
        }
        return result[n][m];
    }

    private static int min(int a, int b, int c) {
        if (a <= b && a <= c)
            return a;
        else if (b < a && b < c)
            return b;
        else
            return c;
    }
}
