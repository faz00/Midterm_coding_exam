package math.problems;

import databases.ConnectToSqlDB;

import java.util.Arrays;
import java.util.List;

public class PrimeNumber {

	public static int[] IsPrime(int n){



		int k=0;
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);

		// We start from 2 because it's the smallest prime number
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				// Mark all multiples of i as not prime
				for (int j = i*i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int count = 0;

		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				count++;

			}
		}
		int[] array = new int[count];
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {

				array[k]=i;
				k++;

			}
		}


		System.out.println("There are " + count + " prime numbers between 2 and 1 million.");

		return array;
	}

	public static void main(String[] args) throws Exception {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

		//IsPrime(100);
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		connectToSqlDB.insertDataFromArrayToSqlTable(IsPrime(100), "Primenumb", "SortingNumbers");
		List<String> numbers = connectToSqlDB.readDataBase("Primenumb", "SortingNumbers");

		for(String st:numbers){
			System.out.print(st+"\t");
		}
		System.out.println();
	}
	}


