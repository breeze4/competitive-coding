package ch1_arrays_and_strings;

public class Ch1_2 {

    public static void main(String[] args) {
        System.out.println(reverse(""));
        System.out.println(reverse(null));
        System.out.println(reverse("a"));
        System.out.println(reverse("as"));
        System.out.println(reverse("asdf"));
        System.out.println(reverse("asdfe"));
    }

    public static String reverse(String str) {
        if (str == null) return null;
        char[] chars = str.toCharArray();

        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            char temp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = temp;
            head++;
            tail--;
        }

        return new String(chars);
    }
}
