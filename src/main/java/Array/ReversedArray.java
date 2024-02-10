package Array;


public class ReversedArray {
    static void reverse(int[] arr,int start,int end){
        int temp;

       if(start>=end){
           return;
       }
       temp = arr[start];
       arr[start] = arr[end];
       arr[end] = temp;
       reverse(arr,start+1,end-1);
    }
}
//
//    Time Complexity: O(n)
//        Auxiliary Space: O(n)
