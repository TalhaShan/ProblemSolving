package DSAShardaAman;

import java.util.Arrays;

public class ProductExceptItSelf {
    //    Example 1:
//
//    Input: nums = [1,2,3,4]
//    Output: [24,12,8,6]
//    Example 2:
//
//    Input: nums = [-1,1,0,-3,3]
//    Output: [0,0,9,0,0]
    public static int[] productExceptSelf(int[] nums) {
        //Approach 1 : Multiply all and then divide each

        //Approch 2 take 2 arrays one with left sum and another with right sum and then merge it
        int N = nums.length;
        int[] output = new int[N];
        int[] leftArr = new int[N];
        int[] rightArr = new int[N];

        leftArr[0] = 1;
        for (int i = 1; i < N; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }
        rightArr[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < N; i++) {
            output[i] = leftArr[i] * rightArr[i];
        }

        return output;
    }

    //SpaceOptimize //  //Approach 3"
    public static int[] productExceptSelfApproach3(int[] nums) {

        int N = nums.length;
        int[] output = new int[N];

        output[0] = 1;
        for (int i = 1; i < N; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = N - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R = R * nums[i];
        }

        return output;
    }


    public static void main(String[] args) {
//        System.out.println(
//                Arrays.toString(productExceptSelfApproach3(new int[]{1, 2, 3, 4}))
//        );
        System.out.println(
                Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))
        );
    }
}
