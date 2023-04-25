package SdeSheet;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    //t: arr[1,1,2,2,2,3,3]


    //Brute force
    //T (Nlogn) ->set insert  + O(N) ->traverse
    //S O(N)
    static int removeDuplicatesBrute(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }
        //First  arr[0] will always be uniques
        //so take i at first pointer
    //take j on 2nd
    //i !=j
    //means next elment after i index should be arr[j]
    //perform arr[i+1] = arr[j]
    //and increase pointet to next unique i++

    //else if  arr[i] == arr[j]
    //just countiue iterate until found unique
    //we can return number of unique element i+1
    static int[] removeDuplicates(int[] arr) {
        int i = 0;

        for (int j = 1; j < arr.length; j++) {
                if(arr[i]!=arr[j]){
                    arr[i+1] = arr[j];
                    i++;
                }

        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3})));
    }
}
