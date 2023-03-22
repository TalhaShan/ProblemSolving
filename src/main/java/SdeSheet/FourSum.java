package SdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

//    Input: nums = [1,0,-1,0,-2,2], target = 0
//    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    //Approach 1 brute force O(N^4)

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> order = new ArrayList<>();
                            order.add(nums[i]);
                            order.add(nums[j]);
                            order.add(nums[k]);
                            order.add(nums[l]);
                            result.add(order);
                        }
                    }

                }
            }
        }

        return result;
    }

    //Time Complexity: O(n³)
    //Reason: There are 2 nested loops and the front pointer as well as the right pointer (Third nested loop)
    //
    //Space Complexity: O(1), (Generally the space complexity that is used to return the answer is ignored)
    //    Approach: Sort the array, and then fix two pointers, so the remaining sum will be (target – (nums[i] + nums[j])).
    //    Now we can fix two-pointers, one front, and another back, and easily use a two-pointer to find the remaining two numbers of the quad.
    //    In order to avoid duplications, we jump the duplicates,
    //    because taking duplicates will result in repeating quads. We can easily jump duplicates, by skipping the same elements by running a loop.
    public static List<List<Integer>> fourSumApproach2(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            //avoid duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //avoid duplicate
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long required = target - (nums[i] + nums[j]);
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == required) {
                        List<Integer> order = new ArrayList<>();
                        order.add(nums[i]);
                        order.add(nums[j]);
                        order.add(nums[left]);
                        order.add(nums[right]);
                        result.add(order);


                        //Avoid duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }///

                        left++;
                        right--;

                    } else if (nums[left] + nums[right] < required) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {

        int nums[] = {1, 0, -1, 0, -2, 2}, target = 0;
        System.out.println(Collections.unmodifiableList(fourSumApproach2(nums, target)));
    }
}
