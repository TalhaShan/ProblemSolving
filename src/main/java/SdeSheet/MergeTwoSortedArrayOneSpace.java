package SdeSheet;

import java.util.Arrays;

public class MergeTwoSortedArrayOneSpace {
    /*
    Input: ar1[] = {10}, ar2[] = {2, 3}
    Output: ar1[] = {2}, ar2[] = {3, 10}

    Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
    Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20
    */

//    1. First approach brute force

//    a. take another array of combine size of arr1 and arr2
//    b. and put all element in it of both array
//    c. sort the array
//    d. put it back index by index on arr1 first and then on 2nd array a/c to their size
//
//     Time Complexity: Nlogn + N + N
//     O(N) for putting in new array
//     Nlogn for sorting new array
//     O(N) for putting it back
//     Space: FOR TAKING NEW ARRAY
//     O(N)

//    Approach 2:

    //As  we know both are sorted
    // we can linearly travverse both at same time
    // Step:
    //check if arr1[i]> arr2[i]
    //swap it and bring arr2[i] of in place of arr1[i]
    //Now as we know both are sorted it won't affect arr1[] because smaller element is coming
    //But it can or may affect arr2, so we will sort the arr2 again after swapping it.
    //also take the pointer of arr 2 back to start
    //repeat the process until arr 1 end or 2

//    Time Complexity: O(N * M)
        //for every N of arr1 we are sorting arr 2 again so its N*M
    //where N is element of arr 1 and
    // M is the sorting on every step after swap assumings worst case scenario.


//Code for Approach 2:

//    static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
//    static int arr2[] = new int[] { 2, 3, 8, 13 };



    static int arr1[] = new int[] { 10 };
    static int arr2[] = new int[] { 2, 3 };

    static void merge(){
        int i = 0;
        int j = 0 ;
        while (i<arr1.length && j< arr2.length){
            if(arr1[i]>arr2[j]){
                swap(i,j,arr1,arr2);
                Arrays.sort(arr2);
            }
            i++;
        }
    }

    private static void swap(int i, int j, int[] arr1, int[] arr2) {
        int temp  = arr1[i];
        arr1[i] =  arr2[j];
        arr2[j] = temp;
    }

    public static void main(String[] args) {
        merge();
        System.out.print("After Merging \nFirst Array: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2));
    }


    //Third Approach With Gap Algo
    //Gap algo says  Calculate N =  Math.ceil[[arr1.length + arr2.length]/2];
    //Steps:
    //we will take 2 pointers i and j
    // i will be placed at the beginning // j will be placed at N //calculated ny gap formula
    //if i >  j //swap
    //if not i++ j++
    //if j becomes out of bound again perform gap this time it will definitely  reduced as we will
    //divide previous gap = PreviousGapResult/2;
    //continue the process
    //if gap becomes 1 then place i on start j on 2  //that will be the last iteration

//    Note: where to place i and j , i will be on start means on first array start
    //j can be on first array or 2nd array depends on the value of gap formula so placed it carefully
    //TIME COMPLEXITY: LOg2N * O(n)
    //where Log2N for dividing //gap
    //N for each iteration after gap starting from start
//    Space O(1)

    //Approach  3 code;
    static void mergeUsingGapAlgo(){
        int N = (int) Math.ceil((arr1.length + arr2.length)/2);
        int len1 = arr1.length-1;
        int len2 =  arr2.length-1;
        int i = 0;
        int j = 0;
        j = N;
        if(j<=len1){
         //its in array 1

        }

    }
}
