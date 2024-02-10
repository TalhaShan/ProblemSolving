package DSAShardaAman;


import java.util.Arrays;

public class QuickSort {

    //YT mycodschool
    // Merge Sort  O(nlogn) - Worst Case running time   //recursive
    // O(n) space complexity  // not in place

    //Quick divi conquer recursive
    //O(nlogn) - Average case running time
    //O(n2) // Worst case  - to avoid technique called randomized is used
    // O(1) space

//    https://www.youtube.com/watch?v=COk73cpQbFQ
 //In memory of legend HumbleFool
    public static int partition (int[] arr,int start, int end){
        int pivot = arr[end];
        int pIndex = start;
        for(int i=start; i<end; i++){
            if(arr[i]<=pivot){
                swap(arr[i],arr[pIndex],arr);
                pIndex++;
            }
        }
        swap(arr[end],arr[pIndex],arr);
        return pIndex;
    }

    public static void swap(int a, int b,int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void quickSort(int[] arr,int start, int end){
        if(start<=end){
            int pIndex=partition(arr,start,end);
            quickSort(arr,start,pIndex-1);
            quickSort(arr,pIndex+1,end);
        }

    }

    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1,0};
        quickSort(arr,0,7);
        System.out.println(Arrays.toString(arr));
    }
}
