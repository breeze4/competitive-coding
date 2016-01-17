package uva.UVA102;

import java.io.IOException;
import java.util.*;

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
     * The Input
     * <p/>
     * The input consists of a series of lines with each line containing 9 integers.
     * The first three integers on a line represent the number of brown, green, and clear bottles
     * (respectively) in bin number 1, the second three represent the number of brown,
     * green and clear bottles (respectively) in bin number 2, and the last three integers
     * represent the number of brown, green, and clear bottles (respectively) in bin number 3.
     * For example, the line 10 15 20 30 12 8 15 8 31
     * <p/>
     * indicates that there are 20 clear bottles in bin 1, 12 green bottles in bin 2, and 15 brown
     * bottles in bin 3.
     * <p/>
     * Integers on a line will be separated by one or more spaces. Your program should process
     * all lines in the input file.
     * <p/>
     * The Output
     * <p/>
     * For each line of input there will be one line of output indicating what color bottles go
     * in what bin to minimize the number of bottle movements. You should also print the minimum
     * number of bottle movements.
     * <p/>
     * The output should consist of a string of the three upper case characters 'G', 'B', 'C'
     * (representing the colors green, brown, and clear) representing the color associated with
     * each bin.
     * <p/>
     * The first character of the string represents the color associated with the first bin,
     * the second character of the string represents the color associated with the second bin,
     * and the third character represents the color associated with the third bin.
     * <p/>
     * The integer indicating the minimum number of bottle movements should follow the string.
     * <p/>
     * If more than one order of brown, green, and clear bins yields the minimum number of
     * movements then the alphabetically first string representing a minimal configuration
     * should be printed.
     * <p/>
     * Sample Input
     * <p/>
     * 1 2 3 4 5 6 7 8 9
     * 5 10 5 20 10 5 10 20 10
     * Sample Output
     * <p/>
     * BCG 30
     * CBG 50
     */

    void Begin() {
        String input;
        StringTokenizer idata;

        // BGC bins 1 2 3
        List<int[]> inputs = new ArrayList<>();

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            idata = new StringTokenizer(input);

            int inputIndex = 0;
            int[] counts = new int[9];
            while (idata.hasMoreTokens())
                counts[inputIndex++] = Integer.parseInt(idata.nextToken());
            inputs.add(counts);
        }

        List<String> out = new ArrayList<>();
        for (int[] counts : inputs)
            out.add(binPack(counts));

        for (String outString : out)
            System.out.println(outString);

    }

    static String binPack(int[] counts) {
        List<String> binPossibilities = Arrays.asList("BCG", "BGC", "CBG", "CGB", "GBC", "GCB");

        Map<String, int[]> allBinMoves = new LinkedHashMap<>(3);
        allBinMoves.put("B", moveBottleToBins(new int[]{counts[0], counts[3], counts[6]}));
        allBinMoves.put("G", moveBottleToBins(new int[]{counts[1], counts[4], counts[7]}));
        allBinMoves.put("C", moveBottleToBins(new int[]{counts[2], counts[5], counts[8]}));

        Map<String, Integer> moveCounts = new LinkedHashMap<>();
        for (String binComboStr : binPossibilities) {
            int binMoveCount = 0;
            char[] binCombo = binComboStr.toCharArray();

            for (int i = 0; i < 3; i++) {
                String bin = new String(new char[]{binCombo[i]});
                int[] moves = allBinMoves.get(bin);
                binMoveCount += moves[i];
            }
            moveCounts.put(binComboStr, binMoveCount);
        }

        String bestBin = "GGG";
        int bestBinCount = Integer.MAX_VALUE;
        for (String binCombo : moveCounts.keySet()) {
            int binCount = moveCounts.get(binCombo);
            if (binCount < bestBinCount ||
                    (binCount == bestBinCount && binCombo.compareTo(bestBin) < 0)) {
                bestBin = binCombo;
                bestBinCount = binCount;
            }
        }

        return bestBin + " " + bestBinCount;
    }

    static int[] moveBottleToBins(int[] startCounts) {
        int moveToBin1 = startCounts[1] + startCounts[2];
        int moveToBin2 = startCounts[0] + startCounts[2];
        int moveToBin3 = startCounts[0] + startCounts[1];
        return new int[]{moveToBin1, moveToBin2, moveToBin3};
    }
}
