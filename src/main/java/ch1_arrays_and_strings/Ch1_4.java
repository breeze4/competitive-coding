package ch1_arrays_and_strings;

public class Ch1_4 {

    public static void main(String[] args) {
        System.out.println(encodeSpaces(toFixedSizeCharArray("a b c"), "a b c".length()));
        System.out.println(encodeSpaces(toFixedSizeCharArray("a b c "), "a b c ".length()));
        System.out.println(encodeSpaces(toFixedSizeCharArray(" a b c"), " a b c".length()));
    }

    public static String encodeSpaces(char[] input, int length) {
        if (input == null) {
            return null;
        }
        int outTail = input.length - 1;
        int inTail = length - 1;
        while (outTail >= 0 && inTail >= 0) {
            if (Character.isWhitespace(input[inTail])) {
                input[outTail--] = '0';
                input[outTail--] = '2';
                input[outTail--] = '%';
            } else {
                input[outTail] = input[inTail];
                outTail--;
            }
            inTail--;
        }

        return new String(input);
    }

    private static char[] toFixedSizeCharArray(String str) {
        char[] input = str.toCharArray();
        // count encoded whitespace additions in length
        int count = 0;
        for (char c : input) {
            if (Character.isWhitespace(c))
                count += 2;
        }

        // add those as extra space at the end of the array
        char[] output = new char[str.length() + count];
        System.arraycopy(input, 0, output, 0, str.length());
        return output;
    }
}
