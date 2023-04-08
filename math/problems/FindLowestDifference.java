package math.problems;

public class FindLowestDifference {

    public static int LowestDiff(int[] a,int[] b){
        int min =a[0];
        for (int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){

                min=Math.min(a[i],b[j]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */
        int [] array1 = {30,12,5,9,2,20,33,1};
        int [] array2 = {18,25,41,47,17,36,14,19};

        System.out.println(LowestDiff(array1,array2));


    }

}
