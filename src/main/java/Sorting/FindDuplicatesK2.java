package Sorting;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesK2 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int num[] = {4,3,2,7,8,2,3,5};
        System.out.println(findDuplicates(num));
    }
}
