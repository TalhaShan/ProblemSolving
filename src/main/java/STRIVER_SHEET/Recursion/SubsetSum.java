package STRIVER_SHEET.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    void subSetRevision(int idx, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubSet) {

        if(idx==N){
            sumSubSet.add(sum); // if go out of index
            return;
        }
        subSetRevision(idx + 1, sum + arr.get(idx), arr, N, sumSubSet);  // take
        subSetRevision(idx + 1, sum, arr, N, sumSubSet);  // not take
    }

    ArrayList<Integer> makeSubset(ArrayList<Integer> arr, int size){
        ArrayList<Integer> subSets = new ArrayList<>();
        subSetRevision(0,0,arr,size,subSets);
        Collections.sort(subSets);
        return subSets;
    }
}
