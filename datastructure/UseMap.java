package datastructure;
import java.util.*;
public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		// Create a Map with String keys and List of String values
		Map<String, List<String>> map = new HashMap<>();

		// Create a List of strings and add it to the Map
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		map.put("fruits", list);

		// Retrieve data from the Map using a for-each loop
		for (String key : map.keySet()) {
			List<String> value = map.get(key);
			System.out.println("Key: " + key);
			System.out.println("Value: " + value);
		}

		// Retrieve data from the Map using a while loop and an Iterator
		Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println("Key: " + key);
			System.out.println("Value: " + value);
		}
	}

}
