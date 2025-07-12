package com.demo.project;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {

    static int maxLength(int[] arr) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;  // simple case only save as index no sum on map
            } else {
                if(map.get(sum)!=null) { //or contains Key
                    max = Math.max(max, i - map.get(sum));
                }else {
                    map.put(sum,i);
                }

            }
        }
        return max;
    }
}
