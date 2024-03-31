package STRIVER_SHEET;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    //    Input: nums = [3,1,-2,-5,2,-4]
//    i j
//            [3,-2,1,-5,2,-4]
//    i j
//    //    Output: [3,-2,1,-5,2,-4]
//    i j

    public static int[] RearrangebySignBbruteForce(int[] A, int n) {

        // Define 2 vectors, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {

            if (A[i] > 0) pos.add(A[i]);
            else neg.add(A[i]);
        }

        // Positives on even indices, negatives on odd.
        for (int i = 0; i < n / 2; i++) {

            A[2 * i] = pos.get(i);
            A[2 * i + 1] = neg.get(i);
        }


        return A;
    }


    public static int[] rearrangeArray(int[] nums) {
        //T O(N), S O(N)
        int posIndex = 0;
        int negIndex = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
