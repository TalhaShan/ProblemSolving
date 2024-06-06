package STRIVER_SHEET.Arrays;

public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[] = new int[m + n];
        int i=0, j = 0, index=0;
        while (i < m && j< n){
            if(nums1[i]<nums2[j]){
                ans[index] = nums1[i];
                index++;
                i++;
            }
            else if(nums2[j]>nums1[i]){
                ans[index] = nums1[j];
                index++;
                j++;
            }else {
                ans[index] =nums1[i];
                index++;
                ans[index] = nums2[j];
                index++;
            }
        }


    }
}
