package uva.UVA11172;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Name class as Main
// default package
class Main {

    static String ReadLn(int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dynamic instance
        myWork.Begin();            // the true entry point
    }

    /**
     * Input
     * First line of the input file is an integer t (t < 15) which denotes how many sets of inputs are there.
     * Each of the next t lines contain two integers a and b (|a|, |b| < 1000000001).
     * Output
     * For each line of input produce one line of output. This line contains any one of the relational operators
     * ‘>’, ‘<’ or ‘=’, which indicates the relation that is appropriate for the given two numbers.
     * Sample Input
     * 3
     * 10 20
     * 20 10
     * 10 10
     * Sample Output
     * <
     * >
     * =
     */

    void Begin() {
        String input;
        StringTokenizer idata;
        boolean firstLine = true;
        int t;
        List<int[]> inputs = new ArrayList<>();
        List<String> output = new ArrayList<>();

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            idata = new StringTokenizer(input);

            if (firstLine) {
                firstLine = false;
                t = Integer.parseInt(idata.nextToken());
            } else {
                int a = Integer.parseInt(idata.nextToken());
                int b = Integer.parseInt(idata.nextToken());
                inputs.add(new int[]{a, b});
            }
        }

        for (int[] array : inputs) {
            String operator = relationalOperators(array[0], array[1]);
            output.add(operator);
        }
        for (String s : output)
            System.out.println(s);
    }

    String relationalOperators(int a, int b) {
        if (a < b) return "<";
        if (a > b) return ">";
        return "=";
    }
}
