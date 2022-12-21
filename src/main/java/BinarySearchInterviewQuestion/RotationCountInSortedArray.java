package BinarySearchInterviewQuestion;

import java.util.Scanner;

public class RotationCountInSortedArray {

    public static int findRotationCount(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid  = start + (end-start)/2;
            if(mid > 0  &&  arr[mid] <arr[mid+1]){
                return  mid;
            }
            if(mid < arr.length-1 && arr[mid]>arr[mid+1]){
                return mid+1;
            }
            if(arr[start]<=arr[mid]){
                //left is sorted so in right
                start = mid+1;
            }else {
                end = mid-1;
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();

        System.out.printf("Rotation Count = %d%n", findRotationCount(a));
    }
}
