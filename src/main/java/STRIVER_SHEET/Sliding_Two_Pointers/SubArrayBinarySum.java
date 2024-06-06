package STRIVER_SHEET.Sliding_Two_Pointers;

import java.util.List;

public class SubArrayBinarySum {
    public int numSubArraysWithSum(List<Integer> nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(List<Integer> nums, int goal) {
        int head = 0, tail = 0, sum = 0, result = 0;
        for (head = 0; head < nums.size(); head++) {
            sum += nums.get(head);
            while (sum > goal && tail <= head) {
                sum -= nums.get(tail);
                tail++;
            }
            result += head - tail + 1;
        }
        return result;
    }

}
