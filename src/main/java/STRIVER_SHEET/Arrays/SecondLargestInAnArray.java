package com.demo.project;

import java.util.Arrays;

public class SecondLargestInAnArray{

    //brute force will be sort and return the [n-2], only if they have the distinct elements
    //other wise you need to do something like this

    //Brute
    static  int secondLargest(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int largest= arr[n-1];
       int secondLargest = -1;
        for(int i = n-2; i>=0; i--){
            if(arr[i]<largest){
                secondLargest = arr[i];
                return secondLargest;
            }
        }
            return secondLargest;
    }

    //Better
    //Fist pass find the largest element
    //second largest = -1
    // Second pass are you greater than current and less than largest. (if arr[i] >  secondlargest && arr[i] !=largest)

     //Optimal

    static  int secondLargestOptimal(int[] arr){
        int largest = arr[0];
        int secondLargest = -1;

        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && arr[i]> secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }



    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{1,2,4,7,7,5}));
    }
}
