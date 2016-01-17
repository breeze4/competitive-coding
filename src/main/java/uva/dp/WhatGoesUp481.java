package uva.dp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class WhatGoesUp481 {

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
        WhatGoesUp481 myWork = new WhatGoesUp481();  // create a dynamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;
        List<Integer> inputsList = new ArrayList<>();
        int index = 0;

        while ((input = WhatGoesUp481.ReadLn(255)) != null) {
            idata = new StringTokenizer(input);
            // program goes here
            if (!idata.hasMoreTokens()) break;
            int in = Integer.parseInt(idata.nextToken());
            inputsList.add(index++, in);
        }
        int maxLen;

        index = 0;
        int[] inputsArr = new int[inputsList.size()];
        for (Integer inp : inputsList) {
            inputsArr[index++] = inp;
        }
        int[] out = longestIncreasingSubsequence(inputsArr);
        Object[] output = new Object[out.length + 1];
        output[0] = out[0];
        output[1] = "-";
        for (int i = 1; i < out.length; i++) {
            output[i + 1] = out[i];
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static int[] longestIncreasingSubsequence(int[] seq) {
        int[] len = new int[seq.length];
        int[] pred = new int[seq.length];

        len[0] = 1;
        pred[0] = -1;
        int maxLen = 0;
        int maxLenPredIdx = 0;

        for (int i = 1; i < seq.length; i++) {
            int prevLongest = 0;
            int prevLongestIdx = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (seq[i] > seq[j] && len[j] > prevLongest) {
                    prevLongest = len[j];
                    prevLongestIdx = j;
                }
            }
            len[i] = prevLongest + 1;
            pred[i] = prevLongestIdx;
            if (len[i] >= maxLen) {
                maxLen = len[i];
                maxLenPredIdx = i;
            }
        }

        int[] result = new int[maxLen + 1];
        result[0] = maxLen;
        result[maxLen] = seq[maxLenPredIdx];
        int resultIdx = maxLen - 1;
        int p = maxLenPredIdx;
        while (resultIdx > 0) {
            int parentIdx = pred[p];
            result[resultIdx] = seq[parentIdx];
            p = parentIdx;
            resultIdx--;
        }
        return result;
    }
}
