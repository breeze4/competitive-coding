package uva.misc.UVA10055;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

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
     * The input contains two numbers in every line. These two numbers in each line denotes the number
     * soldiers in Hashmat’s army and his opponent’s army or vice versa. The input numbers are not greater
     * than 2^32.
     * Input is terminated by ‘End of File’.
     * <p>
     * Output
     * For each line of input, print the difference of number of soldiers between Hashmat’s army and his
     * opponent’s army. Each output should be in seperate line.
     * <p>
     * Sample Input
     * 10 12
     * 10 14
     * 100 200
     * Sample Output
     * 2
     * 4
     * 100
     */
    void Begin() {
        String input;
        StringTokenizer idata;
        List<Long> output = new ArrayList<>();
        long a, b;

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            idata = new StringTokenizer(input);
            a = Long.parseLong(idata.nextToken());
            b = Long.parseLong(idata.nextToken());
            long difference = differenceInArmies(a, b);
            output.add(difference);
        }
        for (long l : output)
            System.out.println(l);
    }

    long differenceInArmies(long hashmatsArmy, long enemyArmy) {
        long difference = enemyArmy - hashmatsArmy;
        return Math.abs(difference);
    }
}
