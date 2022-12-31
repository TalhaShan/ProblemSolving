package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {

    public static List<Integer> findAllDuplicatee(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {

            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int idx =0; idx<arr.length; idx++){
            if(idx+1 !=arr[idx]){
                res.add(arr[idx]);
            }
        }

        return res;
    }

    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int num[] = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicatee(num));
    }
}
