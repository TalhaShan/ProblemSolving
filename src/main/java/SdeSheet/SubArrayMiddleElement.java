package SdeSheet;

import java.util.Arrays;
import java.util.List;

public class SubArrayMiddleElement {

    public static String balancedSums(List<Integer> arr) {

        int n = arr.size();
        for(int i = 0; i<n; i++){

            int leftSum = 0 ;
            for(int j=i-1; j>=0; j-- ){
                leftSum+=arr.get(j);
            }
            int rightSum = 0 ;
            for(int k=i+1 ; k<n; k++ ){
                rightSum+=arr.get(k);
            }

            if(rightSum==leftSum){
                System.out.println(arr.get(i));
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Integer arr1[] = { 1, 4, 2, 5 };

        System.out.println(balancedSums(Arrays.asList(arr1)));

        // Case 2
        Integer arr2[] = { 2, 3, 4, 1, 4, 5 };
        System.out.println(balancedSums(Arrays.asList(arr2)));
    }

}
