package misc;

import com.sun.istack.internal.NotNull;

public class PrintNumbersInBase {

    /**
     * Print numbers in a given base from 0 to 100000
     * Support bases from [2, 10], throw exceptions otherwise
     * Print to system out
     * <p>
     * e.g.: if the base is 2, print:
     * 0
     * 1
     * 10
     * 11
     * 100
     * 101
     * 111
     * ...
     * 1000000
     * <p>
     * base 3:
     * 0
     * 1
     * 2
     * 10
     * 11
     * 12
     * 20
     * 21
     * 22
     * ...
     * 1000000
     */
    public static void main(String[] args) {
//        printTO1Million(2);
        printTO1Million(3);
    }
    private static final Integer ONE_MILLION = 1000000;

    public static void printTO1Million(Integer base) {
        if (base < 2 || base > 10)
            throw new IllegalArgumentException("that base is not supported, enter a base between 2 and 10");

        int number = 0;
        while (number <= ONE_MILLION) {
            System.out.println(number);
            number = convertToBase(number + 1, base);
        }
    }

    private static Integer convertToBase(Integer number, Integer base) {
        // determine if it needs to be converted to the base
        int lastDigit = number % 10;
        if (lastDigit < base) {
            return number;
        } else {
            String numStr = number.toString();
            int diff = 10 - base;
            Integer currentNumber = number;
            // for base 3, add 7*(10 ^ reverse index) to any 3 to "roll" that digit spot over to base 3
            // e.g.:
            // index 4, number = 12223 -> add 7 => 12230
            // index 3, number = 12230 -> add 70 => 12300
            // index 2, number = 12300 -> add 700 => 13000
            // index 1, number = 13000 -> add 7000 => 20000
            // index 0, number = 20000 -> digit at 0 is less than 3, so we're done
            for(int position = numStr.length() - 1; position >= 0; position--) {
                if(numStr.charAt(position) - 48 < base) {
                    return currentNumber;
                } else {
                    currentNumber += diff;
                    diff *= 10;
                    numStr = currentNumber.toString();
                }
            }
            return currentNumber;
        }
    }


}
