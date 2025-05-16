package com.demo.project;

import java.util.Arrays;

public class NumberOfSubSequenceThatSatisifyMinCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int count = 0;
        int n = nums.length;

        int[] powerOf2 = new int[n];
        powerOf2[0] = 1;
        for (int i = 1; i < n; i++) {
            powerOf2[i] = (powerOf2[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + powerOf2[right - left]) % mod;
                left++;
            }
        }

        return count;
    }
//    ⚙️ Why powerOf2 is used?
//    Imagine you fix a pair: nums[left] (smallest) and nums[right] (largest), and you want to count how many valid subsequences you can make between them.
//
//    Let's say between left and right there are k elements (so, right - left elements in between). Each element can either be included or not included in a subsequence.
//
//    So, total combinations = 2^(right - left).
//
//            Hence:
//
//    java
//            Copy
//    Edit
//    powerOf2[i] = 2^i % mod;

//    💡 Why mod (1e9+7)?
//    In competitive programming and interviews:
//
//    Answers can be huge (like billions).
//
//    So to avoid integer overflow, and
//
//    To standardize answers,
//
//    We always take the result modulo 1,000,000,007 (1e9 + 7), which is a large prime.
//
//            Example:
//
//    java
//            Copy
//    Edit
//            count = (count + powerOf2[right - left]) % mod;
    }
