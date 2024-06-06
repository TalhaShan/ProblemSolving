package STRIVER_SHEET.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    //        Example 1:
//        Input Format: N = 3, k = 5, array[] = {2,3,5}
//        Result: 2
//        Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
//
//        Example 2:
//        Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
//        Result: 3
//        Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.

    //Approach 1: Brute Force
    //Generate all sub array  // o(n3)
    public static int sum(int[] arr, long target) {
        int n = arr.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += arr[K];
                }

                if (s == target)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }


    //O(n2)
    public static int sum2(int[] arr, long target) {
        int n = arr.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            long s = 0; // Sum variable
            for (int j = i; j < n; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                s += arr[j];

                if (s == target)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
    }
    //A optimal approach willbe storing the sum at each index, and then do reverse enginenr
    // like prefix sum at index 1, 3  targest was 3 one found  (3,1), now later prefix becomes
    ///6 and prefixsum-target = 6-3, = 3 if 3 exist in our map which means anthoer array is found you can - previous
    //3 to get current 3, but we are finidng lenght of array so get the current index - previous index and store it//\
    //watch striver


    //THis apppracoh works for -ve +ve Zero
    public static int sum3(int[] arr, long target) {
        int n = arr.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += arr[i];

            // if the sum = k, update the maxLen:
            if (sum == target) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - target;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);

                //To handle case like [2,0,0,3],, if we don't put this we will get 1 length however correct length
                //is 3 // 0,0,3
            }
        }

        return maxLen;
    } //O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array. space O(N)


    //The most optimal with tow pointer appraoch only for negative numbers
    public static int sum4(int[] arr, long target) {
        int n = arr.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > target) {
                sum -= arr[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += arr[right];
        }

        return maxLen;

    }




    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = sum(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
