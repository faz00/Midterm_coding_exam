package algorithm;

import org.junit.Assert;

public class UnitTestSorting {

    /*
      This class is about Unit testing for Sorting Algorithm.
     */
    public static void main(String[] args) {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        int [] sortedArray =   {0,1,2,4,5,6,9};
        //Create Sort object
        Sort sort = new Sort();
        //apply unsorted array to selectionSort.

        sort.selectionSort(unSortedArray);

        //verify if the unsorted array is sorted by the selection sort algorithm.
        try {
            System.out.println("Selection: checked" );
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){

            System.out.println("Error on Selection: "+ex.getMessage());
        }


        //insertion
        sort.insertionSort(unSortedArray);
        try {
            System.out.println("Insertion:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);
        }catch(Exception ex){
           System.out.println("Eror on Insertion:" +ex.getMessage());
        }
        //bubble
        sort.bubbleSort(unSortedArray);
        try {

            System.out.println("Bubble:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
        //merge
        sort.mergeSort(unSortedArray);
        try {
            System.out.println("Merge:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
        //quick
        sort.quickSort(unSortedArray);
        try {
            System.out.println("Quick:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
        //heap
        sort.heapSort(unSortedArray);
        try {
            System.out.println("Heap:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
       // bucket
        sort.bucketSort(unSortedArray);
        try {
            System.out.println("Bucket:checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
        //shell
        sort.shellSort(unSortedArray);
        try {

            System.out.println("Shell: checked");
            Assert.assertArrayEquals(sortedArray, unSortedArray);

        }catch(Exception ex){
            ex.getMessage();
        }
        //Now implement Unit test for rest of the sorting algorithm...................below





    }
}
