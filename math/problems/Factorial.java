package math.problems;

public class Factorial {

    static  int Fact(int n){


        if(n<=1){
           return 1;
        }else {
            return n * Fact(n-1);
        }
    }
    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        System.out.println(Fact(5));
    }
}
