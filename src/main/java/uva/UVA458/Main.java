package uva.UVA458;

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
     * The code key for this simple coding is a one for one character substitution based upon a
     * single arithmetic manipulation of the printable portion of the ASCII character set.
     * <p>
     * Your program should accept all sets of characters that use the same encoding scheme and
     * should print the actual message of each set of characters.
     * <p>
     * Sample Input
     * <p>
     * 1JKJ'pz'{ol'{yhklthyr'vm'{ol'Jvu{yvs'Kh{h'Jvywvyh{pvu5
     * 1PIT'pz'h'{yhklthyr'vm'{ol'Pu{lyuh{pvuhs'I|zpulzz'Thjopul'Jvywvyh{pvu5
     * 1KLJ'pz'{ol'{yhklthyr'vm'{ol'Kpnp{hs'Lx|pwtlu{'Jvywvyh{pvu5
     * Sample Output
     * <p>
     * CDC is the trademark of the Control Data Corporation.
     * IBM is a trademark of the International Business Machine Corporation.
     * DEC is the trademark of the Digital Equipment Corporation.
     */

    void Begin() {
        String input;
        StringTokenizer idata;
        // subtract 7 off the decimal value of the ASCII char to find the real value
        // ie: "1" is dec 49; 49 - 7 = dec 42 => "*"
        // first 32 chars (0-31) of the ASCII table are not printable
        // ASCII goes to 127, so if the converted number is below 32, return 127 - diff
        int OFFSET = 7;
        List<String> inputs = new ArrayList<>();
        List<String> outputs = new ArrayList<>();

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            inputs.add(input);
        }
        for (String in : inputs) {
            char[] chars = in.toCharArray();
            char[] decodedChars = new char[chars.length];
            int index = 0;
            for (char c : chars) {
                char decoded = getReplacement(c);
                decodedChars[index++] = decoded;
            }
            outputs.add(new String(decodedChars));
        }
        for (String out : outputs)
            System.out.println(out);
    }

    char getReplacement(char in) {
        char out;
        int encoded = (int) in;
        if (encoded >= 39)
            out = (char) (encoded - 7);
        else {
            // if encoded = 36 ("$"),
            // correctly decoded = (128 - (32 - (36 - 7 = 29) = 3) = 125) = ("}")
            int diff = 32 - (encoded - 7); // how far does it need to wrap around?
            out = (char) (128 - diff);
        }
        return out;
    }


}
