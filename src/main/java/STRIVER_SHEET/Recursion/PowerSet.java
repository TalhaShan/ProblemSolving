package com.demo.project;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private void findSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> output) {
        if (index == nums.length) {
            output.add(new ArrayList<>(current));
            return;
        }

        // Exclude current element
        findSubsets(nums, index + 1, current, output);

        // Include current element
        current.add(nums[index]);
        findSubsets(nums, index + 1, current, output);

        // Backtrack
        current.remove(current.size() - 1);
    }
}