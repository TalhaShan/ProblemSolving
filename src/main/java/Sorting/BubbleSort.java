package Sorting;

import java.util.Arrays;

public class BubbleSort {

    static void bubble(int[] arr){
    //what if array already sorted no need to do all comparisons if swapped did not occur in first place
        boolean swapped=false;
        for(int i=0; i<arr.length; i++){
            for (int j = 1; j<arr.length-i ; j++){
                if(arr[j]<arr[j-1]){
                    int temp =  arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
            int arr[] =  {5,4,3,2,1};
            bubble(arr);
    }
}
