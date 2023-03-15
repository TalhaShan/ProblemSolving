package SdeSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class FindMissingAndDuplicate {

    //Approach#1:

    //Sort the array and then traverse again to find duplicate a[i]==a[i+1] //and index+1 will be missing
    //Complexity O(nlogn)

    //Approach#2
    //take another array of n+1 and mapped the index with value, index with value 2 will be repeating
    //the value with index 0 will be missing;

    //TIme is O(n)
    //Space is O(n)
    //Approach3#
    //We have arr =  {2,1,2,4,5}
    //index would be  1,2,3,4,5
    //here as  we see 3 is missing and 2 is repeating
    //sTEPS:
    //Lets visit first is arr[0] = 2 //ok as per our logic where should be 2 it shoudl on index 2
    //so marked index 2 as  {2,-1,2,4,5}
    //arr[1] = 1 //it should on index 1 so marked index 1 as -ve
    // {-2,-1,2,4,5}
    ///next arr[2] = 2 where should be 2 it should be on index 2 so marked 2 index -ve
    //but we see index 2 is already negative which means 2 is already there before duplicate caught
    //final will be look like this {-2,-1,2,-4,-5}
//                           index={ 1, 2,3, 4, 5}  // the missing is 3 as positive index


    //Lets code approach 3 Space O(1) Time(N)

   static List<Integer> findDupMiss(int[] arr) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            int curr =  Math.abs(arr[i]);
            if (arr[curr-1] < 0) {
                //find duplicate

                res.add(curr);
            } else {
                arr[curr - 1] = -arr[curr - 1];
            }
        }

        int pos = Arrays.stream(arr).filter(x-> x > 0).findFirst().orElse(0);  //finding the positive one

        res.add(++pos);


        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDupMiss(new int[]{2,1,2,4,5}));
    }

}
