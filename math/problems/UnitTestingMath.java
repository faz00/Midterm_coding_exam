package math.problems;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud;

public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. FindLowestDifference");
            System.out.println("4. FindMissingNumber");
            System.out.println("5. LowestNumber");
            System.out.println("6. MakePyramid");
            System.out.println("7. Pattern");
            System.out.println("8. PrimeNumber");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int n=5;
                    System.out.println( "The Factorial of "+n+"is: "+Factorial.Fact(n));  //Factorial
                    break;
                case 2:
                    n=40;
                    System.out.println("The Fibonacci of number "+n+"is: ");
                    System.out.print(Fibonacci.Fib(0) );
                    for(n=1;n<40;n++) {
                        System.out.print(","+Fibonacci.Fib(n) );
                    }
                    break;
                case 3:
                    System.out.println("The lowest difference between the two arrays is: ");
                    int [] array1 = {30,12,5,9,2,20,33,1};
                    int [] array2 = {18,25,41,47,17,36,14,19};
                    System.out.println(FindLowestDifference.LowestDiff(array1,array2));
                    break;
                case 4:
                    System.out.println("The missing number in this array is : ");
                    int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
                    System.out.println(FindMissingNumber.helper(array));
                    break;
                case 5:
                    System.out.println("The Lowest number : ");

                    break;
                case 6:
                    System.out.println("The Pyramid : ");
                    int m=6;
                    MakePyramid.Pyramide(m);
                    break;
                case 7:
                    System.out.println("The Pattern: ");
                    int l=100;
                    Pattern.FindPattern(l);
                    break;
                case 8:
                    System.out.println("The prime Number: ");
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 9);














    }
}
