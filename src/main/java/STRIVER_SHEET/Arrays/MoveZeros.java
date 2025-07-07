package com.demo.project;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        //HARD FORCE APPROACH
        //1. Take 2 arrays one for non zero element and other for zero elements
        //2. combine them in third array as result
        //3. We may need count for zero and non zero to initlaize or use list

        //Optimize way
        if (nums.length <= 1)
            return;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(left, right, nums);
                left++;
            }
            right++;
        }
    }

    void swap(int left, int right, int nums[]) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
