package ch1_arrays_and_strings;

public class Ch1_5 {

    public static void main(String[] args) {
        System.out.println(compress("aabbbcc"));
        System.out.println(compress("abc"));
        System.out.println(compress("aaa"));
        System.out.println(compress("aaaabababacc"));
        System.out.println(compress("aaaabababaccccccccccccc"));
        System.out.println(compress("aaaabababacccccccccccccd"));
    }

    public static String compress(String input) {
        if (input == null || input.length() <= 2) {
            // invalid or too short for compression to be of value
            return input;
        }
        StringBuilder sb = new StringBuilder();
        char[] in = input.toCharArray();

        char current = in[0];
        int currentCount = 1;
        for (int i = 0; i < in.length; i++) {
            if (current == in[i] && i != in.length - 1) {
                // is the same and is not the very last
                currentCount++;
            } else if (current == in[i] && i == in.length - 1) {
                // is the same and is the very last
                currentCount++;
                sb.append(current);
                sb.append(currentCount);
            } else if (i == in.length - 1 && current != in[i]) {
                // input value is different and its the end
                sb.append(current);
                sb.append(currentCount);
                current = in[i];
                currentCount = 1;
                sb.append(current);
                sb.append(currentCount);
            } else {
                sb.append(current);
                sb.append(currentCount);
                current = in[i];
                currentCount = 1;
            }
        }

        if (sb.length() >= input.length()) {
            return input;
        }
        return sb.toString();
    }
}
