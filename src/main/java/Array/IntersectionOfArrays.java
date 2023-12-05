package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfArrays {

    public static int[] intersectArrays(int[] nums1, int[] nums2) {

//        Example 1:
//
//        Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        Output: [2,2]
//        Example 2:
//
//        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [4,9]
//        Explanation: [9,4] is also accepted.
        boolean one = nums1.length > nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (one) {

            for(int i=0; i<nums1.length; i++){
                if(map.containsKey(nums1[i])){
                    map.put(nums1[i],map.get(nums1[i])+1);
                }else{
                    map.put(nums1[i],1);
                }
            }
            for(int i=0; i<nums2.length; i++){
                if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                    res.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);

                }
            }

        } else {

            for(int i=0; i<nums2.length; i++){
                if(map.containsKey(nums2[i])){
                    map.put(nums2[i],map.get(nums2[i])+1);
                }else{
                    map.put(nums2[i],1);
                }
            }
            for(int i=0; i<nums1.length; i++){
                if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0){
                    res.add(nums1[i]);
                    map.put(nums1[i],map.get(nums1[i])-1);

                }
            }

        }
        return res.stream().mapToInt(i->i).toArray();
    }

//WITH SORITNG
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < l1 && j < l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectArrays(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}

