package STRIVER_SHEET.Arrays.GreedyAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RailwayPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int count = 0, maxCount = 0;
        while (i < n && j < n) {
            if (arr[i]<=dep[j]){
                i++;
                count++;
            }else if(arr[i]>dep[j]){
                j++;
                count--;
            }
            maxCount =Math.max(count,maxCount);
        }
        return maxCount;
        //T 2(Nllogn)
        //S O(1)
    }

    //Another we can do this is sorting and combining in single array or hashmap

    int[] arr ={900,945,955,1100,1500,1800};
    int[] dep={920,1200,1130,1150,1900,2000};
    //(900, A)(920,D)(945,A)(955,A)(1130,D)(1200,D)  // so idea is to sort on basis of time
    //And on every arrival platform_++;
    //And on every departure platform--;
}
