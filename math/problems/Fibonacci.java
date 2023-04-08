package math.problems;

public class Fibonacci {
    public static int Fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Fib(n-1) + Fib(n-2);
        }
    }
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */
        int n ;
        System.out.print(Fib(0) );
        for(n=1;n<40;n++) {
            System.out.print(","+Fib(n) );
        }
    }
}
