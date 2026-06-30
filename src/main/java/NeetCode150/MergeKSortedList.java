package NeetCode150;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode merged = dummy;
        while (!minHeap.isEmpty()) {
            merged.next = new ListNode(minHeap.remove());
            merged = merged.next;
        }
        return dummy.next;
    }

}


