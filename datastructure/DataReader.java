package datastructure;
import databases.ConnectToSqlDB;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Stack;
public class DataReader {

	public static <e> void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		/*
		 * Use API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		//String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car.txt";
		String textFile = System.getProperty("user.dir") + "\\data\\self-driving-car";


		try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
			String line;
			LinkedList<String> linkedList = new LinkedList<>();
			Stack<String> stack = new Stack<>();

			// read the file line by line
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+"); // split the line into words

				// add each word to the linked list and stack
				for (String word : words) {
					linkedList.addLast(word);
					stack.push(word);
				}
			}

			// iterate over the linked list using a forEach loop
			System.out.println("Retrieving data from LinkedList as FIFO:");
			for (String word : linkedList) {
				System.out.println(word);
			}

			// iterate over the stack using a while loop and an iterator
			System.out.println("\nRetrieving data from Stack as FILO:");
			while (!stack.empty()) {
				String word = stack.pop();
				System.out.println(word);
			}

		} catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage());
		}


		//Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		String textFile1 = System.getProperty("user.dir") + "\\data\\self-driving-car";
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		ConnectToSqlDB.connectToSqlDatabase();
		try (BufferedReader reader = new BufferedReader(new FileReader(textFile1)))
		{


				// create a table to store the words and their positions
				String createTableSQL = "CREATE TABLE IF NOT EXISTS word_position ("
						+ "id INT(11) NOT NULL AUTO_INCREMENT, "
						+ "word VARCHAR(255) NOT NULL, "
						+ "position INT(11) NOT NULL, "
						+ "PRIMARY KEY (id))";

				PreparedStatement ps;
				//connectToSqlDB.ps.executeUpdate(createTableSQL);
			try{
			   ps = connectToSqlDB.connect.prepareStatement(createTableSQL);

			   ps.executeUpdate();
			}catch (Exception e) {

				System.out.println("Check your connection:" +e.getMessage());
			}

				// insert each word into the table with its position in the file
				String insertSQL = "INSERT INTO word_position (word, position) VALUES (?, ?)";
				int position = 1;
				String line;

				while ((line = reader.readLine()) != null) {
					String[] words = line.split("\\s+"); // split the line into words
					for (String word : words) {
						ps = ConnectToSqlDB.connect.prepareStatement(insertSQL);
						ps.setString(1, word);
						ps.setInt(2, position);
						ps.executeUpdate();
						position++;
					}
				}
				System.out.println("Data successfully inserted into MySQL database.");
			}catch (Exception e ) {


			System.out.println("Error reading file: " + e.getMessage());
		}
			//Demonstrate how to use Stack that includes push,peek,search,pop elements.
			// Use For Each loop/while loop/Iterator to retrieve data.
		Stack<String> stack = new Stack<>();
		LinkedList<String> list = new LinkedList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					stack.push(word);
					list.addLast(word);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Retrieve data using for-each loop
		System.out.println("Retrieving data from LinkedList using for-each loop:");
		for (String word : list) {
			System.out.print(word + " ");
		}
		System.out.println("\nRetrieving data from Stack using for-each loop:");
		for (String word : stack) {
			System.out.print(word + " ");
		}

		// Retrieve data using while loop
		System.out.println("\n\nRetrieving data from LinkedList using while loop:");
		int index = 0;
		while (index < list.size()) {
			System.out.print(list.get(index) + " ");
			index++;
		}
		System.out.println("\nRetrieving data from Stack using while loop:");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

		// Retrieve data using Iterator
		System.out.println("\n\nRetrieving data from LinkedList using Iterator:");
		var it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("\nRetrieving data from Stack using Iterator:");
		var stackIt = stack.iterator();
		while (stackIt.hasNext()) {
			System.out.print(stackIt.next() + " ");
		}
		}
	}


