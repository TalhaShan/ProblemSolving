package STRIVER_SHEET;

public class MajorityElementOne {

    /*
    If always have a element as given which mean any element will must have n/2 times in an array so
    its count will survive when it will be candidate
     */
    public int majorityElement(int[] nums) {
        int candidate = 0 ;
        int count = 0 ;

        for(int element:nums){
            if(count==0){
                candidate = element;
            }

            count = candidate==element?++count:--count;
//            if(candidate == element){
//                count++;
//            }else{
//                count--;
//            }
        }
        return candidate;
    }
}

