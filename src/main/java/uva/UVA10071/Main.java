package uva.UVA10071;

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
     * The input will contain two integers in each line. Each line makes one set of input. These two integers
     * denote the value of v (−100 ≤ v ≤ 100) and t (0 ≤ t ≤ 200) (t means at the time the particle gains
     * that velocity)
     * Output
     * For each line of input print a single integer in one line denoting the displacement in double of that time.
     * Sample Input
     * 0 0
     * 5 12
     * Sample Output
     * 0
     * 120
     */

    void Begin() {
        String input;
        StringTokenizer idata;
        List<Long> output = new ArrayList<>();
        long v, t;

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            idata = new StringTokenizer(input);
            v = Long.parseLong(idata.nextToken());
            t = Long.parseLong(idata.nextToken());
            // program goes here
            output.add(calculateDisplacement(v, t));

        }
        for (long l : output)
            System.out.println(l);
    }

    long calculateDisplacement(long v, long t) {
        // give velocity v at time t
        // calculate the displacement in double the time, IE: d = v * 2t
        return v * 2 * t;
    }
}
