package math.problems;

public class Pattern {

	public static void FindPattern(int n){

		int decreaseBy = 1; // Set the amount to decrease by

		// Iterate until the number is less than or equal to 0
		while (n > 0) {
			System.out.print(n + " "); // Print the current number
			n -= decreaseBy; // Decrease the number by the set amount

			// If the number is less than or equal to 0, break out of the loop
			if (n <= 0) {
				break;
			}

			// If the number is a multiple of 10, adjust the amount to decrease by
			if (n % 10 == 0) {
				decreaseBy++; // Increase the amount to decrease by
			}
		}
	}
	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */
		
     int n=100;
	 FindPattern(100);

	}
}
