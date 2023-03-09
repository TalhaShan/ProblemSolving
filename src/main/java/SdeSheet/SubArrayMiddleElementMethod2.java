package SdeSheet;

import java.util.Arrays;
import java.util.List;

public class SubArrayMiddleElementMethod2 {
    // Java program to find an element
// such that sum of right side element
// is equal to sum of left side

        // Function to compute partition
        static int findElement(int arr[], int size)
        {
            int right_sum = 0, left_sum = 0;

            // Computing right_sum
            for (int i = 1; i < size; i++)
                right_sum += arr[i];

            // Checking the point of partition
            // i.e. left_Sum == right_sum
            for (int i = 0, j = 1; j < size; i++, j++) {
                right_sum -= arr[j];
                left_sum += arr[i];

                if (left_sum == right_sum)
                    return arr[i + 1];
            }

            return -1;
        }



    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        int rightSum = 0;
        for(int i=1; i<arr.size(); i++){
            rightSum+=arr.get(i);
        }
        int leftSum =0;
        for(int i = 0, j = 1; j < arr.size(); i++, j++){
            leftSum+=arr.get(i);
            rightSum-=arr.get(j);

        }
        if(leftSum==rightSum){
            return "YES";
        }

        return "NO";
    }


        // Driver
        public static void main(String args[])
        {
            int arr[] = { 0 ,0 ,2 ,0 };
            int size = arr.length;
            System.out.println(findElement(arr, size));
            balancedSums(Arrays.asList(2,3,4,1,4,5));

        }
    }
// This code is contributed by Sumit Ghosh


