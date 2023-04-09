package algorithm;

import databases.ConnectToSqlDB;


import java.util.*;

public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.
	 *
	 * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
	 *
	 */

	public static void main(String[] args) throws Exception {

		HashMap<String, Long> timeSorting = new HashMap<String, Long>();
		int [] num = new int[1000000];
		storeRandomNumbers(num);
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		Sort algo = new Sort();
		//Selection Sort

		algo.selectionSort(num);
		long selectionSortExecutionTime = algo.executionTime;

		timeSorting.put("selection",selectionSortExecutionTime );

		System.out.println("Total Execution Time of  "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectToSqlDB.insertDataFromArrayToSqlTable(num, "selection_sort", "SortingNumbers");
        List<String> numbers = connectToSqlDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(numbers);

		int n = num.length;
		randomize (num, n);
		System.out.println();


		//Insertion Sort
		algo.insertionSort(num);
		long insertionSortExecutionTime = algo.executionTime;
		timeSorting.put("Insertion",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "insertion_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("insertion_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);
		System.out.println();
		//By following above, Continue for rest of the Sorting Algorithm....

		//bubbleSort
		algo.bubbleSort(num);
		long bubbleSortExecutionTime = algo.executionTime;
		timeSorting.put("Bubble",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in bubble Sort take: " + bubbleSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "bubble_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("bubble_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);
		System.out.println();


		//mergeSort
		/*algo.mergeSort(num);
		long mergeSortExecutionTime = algo.executionTime;
		timeSorting.put("Merge",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in merge Sort take: " + mergeSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "merge_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("merge_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);
		System.out.println();*/


		//quickSort

		algo.quickSort(num);
		long quickSortExecutionTime = algo.executionTime;
		timeSorting.put("Quick",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in quick Sort take: " + quickSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "quick_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("quick_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);
		System.out.println();


		//heapSort
		algo.heapSort(num);
		long heapSortExecutionTime = algo.executionTime;
		timeSorting.put("Heap",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in heap Sort take: " + heapSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "heap_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("heap_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);
		System.out.println();


		//bucketSort
		algo.bucketSort(num);
		long bucketSortExecutionTime = algo.executionTime;
		timeSorting.put("Bucket",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in bucket Sort take: " + bucketSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "bucket_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("bucket_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);

		System.out.println();


		//shellSort

		algo.shellSort(num);
		long shellSortExecutionTime = algo.executionTime;
		timeSorting.put("Shell",selectionSortExecutionTime );
		System.out.println("Total Execution Time of " + num.length + " numbers in shell Sort take: " + shellSortExecutionTime + " milli sec");

		connectToSqlDB.insertDataFromArrayToSqlTable(num, "shell_sort", "SortingNumbers");
		numbers = connectToSqlDB.readDataBase("shell_sort", "SortingNumbers");
		printValue(numbers);

		n = num.length;
		randomize (num, n);

		String key= Collections.min(timeSorting.entrySet(),Map.Entry.comparingByKey()).getKey();

		System.out.println("the best sorting algorithme is:  " + key);
		//Come to conclusion about which Sorting Algo is better in given data set.

	}

	public static void storeRandomNumbers(int [] num){
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(1000000);
		}
	}

	public static void randomize( int arr[], int n) {
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	public static void printValue(List<String> array){
		for(String st:array){
			System.out.print(st+"\t");
		}
		System.out.println();
	}
}
