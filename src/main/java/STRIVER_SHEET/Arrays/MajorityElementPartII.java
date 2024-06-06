package STRIVER_SHEET.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementPartII {
    /*
    Element >  n/3, Well logically in this case there can be only 2 candiates
    i.e 9/3 =3 , so to be be true atleast 4 times should appear so it can be like 4+4+1 elements count
    for best case scenario
    8/3 = 2 , so to satisfy atleast 3 count , 3+ 3 +2 best case for maximum number
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
            } else if (count2 == 0) {
                candidate2 = nums[i];
            } else {
                count2--;
                count1--;
            }
        }
        count2 = 0;
        count1 = 0;
        //Can be there case will there be no canidate
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;

    }
}
