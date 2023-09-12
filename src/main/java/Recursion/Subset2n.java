package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset2n {

    static void subsetSumsHelper(int ind, int sum, ArrayList < Integer > arr,
                                 int N, ArrayList< Integer > sumSubset) {
        if (ind == N) {
        sumSubset.add(sum);
        }

        subsetSumsHelper(ind+1,sum+arr.get(ind),arr,N,sumSubset);

        subsetSumsHelper(ind+1,sum,arr,N,sumSubset);
    }
    static ArrayList < Integer > subsetSums(ArrayList < Integer > arr, int N) {

        ArrayList < Integer > sumSubset = new ArrayList < > ();
        subsetSumsHelper(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    public static void main(String args[]) {
//      String mes = "Hello";
//      for(int i =44; i>40; i--){
//          System.out.println("exter");
//      }
//        System.out.println("apple".compareTo("banan"));
        System.out.println(args[2]);
    }
}
