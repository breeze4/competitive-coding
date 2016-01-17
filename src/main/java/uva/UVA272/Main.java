package uva.UVA272;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
     * Input and Output
     * <p>
     * Input will consist of several lines of text containing an even number of double-quote (") characters.
     * Input is ended with an end-of-file character. The text must be output exactly as it was input except that:
     * <p>
     * the first " in each pair is replaced by two ` characters: `` and
     * the second " in each pair is replaced by two ' characters: ''.
     * Sample Input
     * <p>
     * "To be or not to be," quoth the Bard, "that
     * is the question".
     * The programming contestant replied: "I must disagree.
     * To `C' or not to `C', that is The Question!"
     * Sample Output
     * <p>
     * ``To be or not to be,'' quoth the Bard, ``that
     * is the question''.
     * The programming contestant replied: ``I must disagree.
     * To `C' or not to `C', that is The Question!''
     */

    private static final char QUOTES = '\u0022';
    private static final char[] BACKTICKS = new char[]{'\u0060', '\u0060'};
    private static final char[] SINGLE_QUOTES = new char[]{'\'', '\''};

    void Begin() {
        String input;
        StringTokenizer idata;
        List<String> outputs = new ArrayList<>();

        // strategy:
        // grab each line into a string
        // turn into char array
        // copy into an output char array
        // when a " is encountered, call getReplaceChar(counter) to get the correct replacement char
        // keep a boolean counter that flips every time a replacement is made
        boolean counter = true;
        while ((input = Main.ReadLn(255)) != null) {
            StringBuilder outChars = new StringBuilder();
            if (input.equals("")) break;
            char[] inChars = input.toCharArray();

            int index = 0;
            while (index < inChars.length) {
                char c = inChars[index];
                if (c == QUOTES) {
                    char[] replacement = getReplaceChar(counter);
                    outChars.append(replacement);
                    counter = !counter;
                } else
                    outChars.append(c);

                index++;
            }
            outputs.add(outChars.toString());
        }

        for (String s : outputs)
            System.out.println(s);
    }

    char[] getReplaceChar(boolean counter) {
        return counter ? BACKTICKS : SINGLE_QUOTES;
    }
}
