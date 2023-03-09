package SdeSheet;

public class SortZerosOnesTwos {
    //variation Dutch national flag algo
    //There are three possible way to sort since we have 0 1 2
    // 1. We can use simple merge sort it will do my work.  T(nlogn) S(1)
    // 2. Use count base approach count 0 1 2 in  variable and then insert in an array. a/c to count .  T O(n)+O(n) S(1)
    // 3. Initialize 3 pointers and swap a/c to situation T(logn) S(1)

    // 1.We will be using third approach to solve this problem low and mid-pointer will be at left
    // 2.high pointer will be at last.
    // 3. we will be moving only mid-pointer until high<mid;

    //[0....low-1] == 0
    //[high+1....]==2

    //case a mid-pointer encounter == 0
    //swap mid , low , mid++ , low++

    //case b mid pointer encounter == 1
    //just mid++

    //case c mid-pointer encounter == 2
    //swap mid,high , and only high --
    public static void sortColors(int[] nums) {
        int low =   0;
        int high  =  nums.length-1;
        int mid =  0;

        while(high<=mid){
            if(nums[mid]==0){
                swap(mid,low,nums);
                mid++;
                low++;

            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(mid,high,nums);
                high--;
            }
        }
    }

    public static void swap(int first,int second, int[] nums){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int nums[] =  {2,0,2,1,1,0};
        sortColors(nums);
    }
}
