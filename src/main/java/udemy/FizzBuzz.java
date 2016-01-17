package udemy;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        fb.fizzbuzz(100);
    }

    public void fizzbuzz(int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                out.append("FizzBuzz");
            else if (i % 3 == 0)
                out.append("Fizz");
            else if (i % 5 == 0)
                out.append("Buzz");
            else
                out.append(i);
            System.out.println(out.toString());
            out.delete(0, out.length());
        }

    }
}
