package DSAShardaAman;


import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {  // thats O(NLOGN)
        Arrays.sort(nums);
        int ans =0;
        for(int i = nums.length-1; i>=0; i--){
            if(k==1){
                ans = nums[i];
                break;
            }
            k--;
        }

    return ans;
    }

    //Method 2 Heap
   // Max Heap  - KthLargestElement----> 0(N+KlogN); //logN to hepify after each pop  // n-K //sorted in desc
    // Min Heap  - KthLargestElement----> 0(N+(N-k+1)log(N-k+1)); //logN to hepify after each pop  // (n-K) +1 //sorted in asc

    static  Integer kthLargestMaxHeap(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //compartor
        for(int i =0 ; i <arr.length; i++){
            pq.add(arr[i]);
        }
        int f = k-1;
        while (f>0){
            pq.remove();
            f--;
        }
        return pq.peek();
    }

    static void kth_Smallest_MinHeap(int[] arr, int k) {

        PriorityQueue<Integer>pq= new PriorityQueue<>();
        int n = arr.length  ;

        for (int i = 0; i < n; i++) {
            pq.add(arr[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }

        System.out.println("Kth Smallest element "+pq.peek())  ;
    }
   //Approcah 3 Quick Sort

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
