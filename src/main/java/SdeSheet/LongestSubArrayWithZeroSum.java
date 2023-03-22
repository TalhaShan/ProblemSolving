package SdeSheet;

import java.util.HashMap;

public class LongestSubArrayWithZeroSum {

    static int subArraySumZero(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;

    }

    //Approach 2 Optimize
    //We will maintain prefixx sum till index so fat
    //if submission becomes 0 it means its the first one or first sub array with 0 we get the max length by current index+1
    //if  submission is not 0 we will check if does not exist submission which is key we will simply put it with index as val thats to maintain prefix sum
    //if submission exist in hashmap which means there is previous subarray that makes the same submission value
    //which means there must be some elements in b.w both that makes 0 becuase both got the same submission value at different index
    //so in b.w both index there must be all the  elements that makes 0
    static int subArrayOptimize(int[] arr) {
        int submission = 0;
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            submission+=arr[i];
            if(submission==0){
                max = i+1;
            }else{
                if(map.get(submission)!=null){
                    max = Math.max(max,i-map.get(submission));

                }else {
                    map.put(submission,i);
                }
            }
        }

    return max;
    }


    public static void main(String args[]) {
        int arr[] = {9, -3, 3, -1, 6, -5};
        System.out.println(subArraySumZero(arr));
    }
}


