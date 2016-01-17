package ch1_arrays_and_strings;

import java.util.Arrays;
import java.util.Collections;

public class Ch1_6 {

    public static void main(String[] args) {
        Object[][] test0 = {
                {1, 2},
                {3, 4}};
        Object[][] expected0 = {
                {3, 1},
                {4, 2}};
        rotate90DegreesCW(test0);
        System.out.println("actual: " + Arrays.deepToString(test0));
        System.out.println("expected: " + Arrays.deepToString(expected0));
        System.out.println(Arrays.deepEquals(test0, expected0));
        Object[][] test1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Object[][] expected1 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};
        rotate90DegreesCW(test1);
        System.out.println("actual: " + Arrays.deepToString(test1));
        System.out.println("expected: " + Arrays.deepToString(expected1));
        System.out.println(Arrays.deepEquals(test1, expected1));
        Object[][] test2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        Object[][] expected2 = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};
        rotate90DegreesCW(test2);
        System.out.println("actual: " + Arrays.deepToString(test2));
        System.out.println("expected: " + Arrays.deepToString(expected2));
        System.out.println(Arrays.deepEquals(test2, expected2));
        Object[][] test3 = {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 6}};
        Object[][] expected3 = {
                {1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6}};
        rotate90DegreesCW(test3);
        System.out.println("actual: " + Arrays.deepToString(test3));
        System.out.println("expected: " + Arrays.deepToString(expected3));
        System.out.println(Arrays.deepEquals(test3, expected3));
    }

    public static void rotate90DegreesCW(Object[][] in) {
        if (in == null || in.length <= 1) {
            return;
        }
        // Assumed to be a square NxN
        int N = in.length;

        for (int i = 0; i <= N / 2; i++) {
            int maxSteps = N - i - 2;
            for (int step = i; step <= maxSteps; step++) {

                Object a = in[i][step];
                Object d = in[N - step - 1][i];
                Object c = in[N - 1 - i][N - step - 1];
                Object b = in[step][N - 1 - i];
                in[i][step] = d;
                in[N - step - 1][i] = c;
                in[N - 1 - i][N - step - 1] = b;
                in[step][N - 1 - i] = a;
            }
        }
    }
}
