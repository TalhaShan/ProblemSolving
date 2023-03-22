package SdeSheet;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //Time Complexity: O(N), where N = size of the array.
    //Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).
    //
    //Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N* logN) as the map data structure takes logN time to find an element.
    //
    //Space Complexity: O(N) as we use the map data structure.
    public static int[] twoSum(int n, int[] arr, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();

        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        for (int i = 0; i < n; i++) {
            int curr = target - arr[i];
            if (sum.containsKey(curr)) {
                res[0] = sum.get(curr); //return value when provide key
                res[1] = i;
            } else {
                sum.put(arr[i], i);
            }
        }

        return res;
    }

    //Approach 2:
//Time Complexity: O(N) + O(N*logN), where N = size of the array.
//Reason: The loop will run at most N times. And sorting the array will take N*logN time complexity.
//
//Space Complexity: O(1) as we are not using any extra space.
    public static int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        int tesp[] =  Arrays.copyOf(arr,arr.length);
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                left++;
                right--;

            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
//        System.out.println(Arrays.toString(twoSum(arr.length, arr, target)));
        System.out.println(Arrays.toString(twoSum(arr, target)));


    }
}
