package NeetCode150;

import java.util.PriorityQueue;

public class KthLargestInStream {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int x : nums) {
            add(x);
        }

    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            //time to pop and readjust
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

