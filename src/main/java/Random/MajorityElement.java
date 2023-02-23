package Random;

public class MajorityElement {
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
