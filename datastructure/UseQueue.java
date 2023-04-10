package datastructure;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		Queue<String> queue = new LinkedList<>();

		// add elements to the Queue using add() method
		queue.add("element 1");
		queue.add("element 2");
		queue.add("element 3");

		// peek the first element in the Queue using peek() method
		String firstElement = queue.peek();
		System.out.println("First element: " + firstElement);

		// remove the first element from the Queue using remove() method
		String removedElement = queue.remove();
		System.out.println("Removed element: " + removedElement);

		// poll the first element from the Queue using poll() method
		String polledElement = queue.poll();
		System.out.println("Polled element: " + polledElement);

		// peek the first element in the Queue again using peek() method
		String newFirstElement = queue.peek();
		System.out.println("New first element: " + newFirstElement);


		// iterate over the queue using a forEach loop
		System.out.println("Using forEach loop:");
		for (String element : queue) {
			System.out.println(element);
		}

		// iterate over the queue using a while loop and Iterator
		System.out.println("\nUsing while loop and Iterator:");
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}

	}

}
