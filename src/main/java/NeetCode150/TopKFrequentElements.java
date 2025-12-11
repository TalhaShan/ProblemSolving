package NeetCode150;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length==1){
            return nums;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(map::get));

//        Queue<Integer> heap = new PriorityQueue<>(
//                (a,b) -> map.get(a)-map.get(b));
        //maintains ascending order
        //Now we put it in the heap
        for(int x: map.keySet()){
            heap.add(x);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }
        return ans;
    }
}
