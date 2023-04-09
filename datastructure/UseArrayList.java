package datastructure;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import databases.ConnectToSqlDB;
public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */

		// Creating an ArrayList of strings
		ArrayList<Integer> list = new ArrayList<>();

		// Adding elements to the ArrayList
		list.add(256);
		list.add(598);
		list.add(23);
		list.add(2);
		list.add(5879);

		// Peeking at the first element of the ArrayList
		System.out.println("First element: " + list.get(0));

		// Removing the second element from the ArrayList
		list.remove(1);

		// Retrieving all the elements from the ArrayList using a for-each loop
		System.out.println("Elements in the ArrayList:");
		for (int n : list) {
			System.out.println(n);
		}

		// Retrieving all the elements from the ArrayList using a while loop with an Iterator
		System.out.println("Elements in the ArrayList (using an Iterator):");
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}


		// Storing all the sorted data into a database


		// Sort the ArrayList
		Collections.sort(list);

		// Connect to the database
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

			// Insert the sorted data into the table

			connectToSqlDB.insertDataFromlistToSqlTable(list, "sorted_data", "SortingNumbers");


			System.out.println("Sorted data has been stored in the database.");

		}


	}


