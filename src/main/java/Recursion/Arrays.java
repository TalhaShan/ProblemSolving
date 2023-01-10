package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    static  boolean isSorted(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        if(arr[index]<arr[index+1]){
            return isSorted(arr,index+1);
        }else {
            return false;
        }

    }

    static int LinearSearch(int[] arr, int target, int idx){

        if(idx>arr.length-1){
            return -1;
        }
        if(target==arr[idx]){
            return idx;
        }

        return LinearSearch(arr,target,idx+1);
    }
    static  boolean isSortedCons(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index] < arr[index+1] &&  isSortedCons(arr,index+1);

    }


    static List<Integer> findAllIndex(int[] arr,int target, int idx,List<Integer> res){

        if(idx==arr.length){
            return res;
        }
        if(arr[idx]==target){
            res.add(idx);
        }
        return findAllIndex(arr,target,idx+1,res);
    }


    static List<Integer> findAllIndexNoArgs(int[] arr,int target, int idx){

        ArrayList<Integer>  res = new ArrayList<>();
        if(idx==arr.length){
            return res;
        }
        if(arr[idx]==target){
            res.add(idx);
        }
        List<Integer> resOfBelowCalls = findAllIndexNoArgs(arr,target,idx+1);
        res.addAll(resOfBelowCalls);  //when all recursive func call finish then it will came here
        return res;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,6};
      //  System.out.println(isSortedCons(arr,0));
//        System.out.println(LinearSearch(arr,10,0));

        System.out.println(findAllIndex(arr,4,0, new ArrayList<>()));
        System.out.println(findAllIndexNoArgs(arr,4,0));

    }
}
