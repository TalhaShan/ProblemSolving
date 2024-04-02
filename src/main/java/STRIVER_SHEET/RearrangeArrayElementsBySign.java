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

    //    Variety-2
//    Problem Statement:
//    There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.
//
//    Note: Start the array with positive elements.
//
//    Examples:
    public static ArrayList<Integer> rearrangeArrayButWithoutEqualPosNeg(ArrayList<Integer> A) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = A.size();
        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int arr[] = {28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
