package Nov;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {
        //subract -1 from all values and put -1 on that index
        //if index already -1 <0 then means we have foudn duplicate becuase -1 will alwyays res in same index
        //so add to list
        //else make numebr  -1 becuase we can first time
        //abs used to discard - neg effect
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
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(arr));

    }
}
