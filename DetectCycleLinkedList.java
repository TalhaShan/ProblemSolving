package NeetCode150;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class DetectCycleLinkedList {


    //Approach 1 Brute force having hashset and keep visited one Node in hashset

    //Approach 2 slow and fast pointer

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){

            fast = fast.next.next;
            slow = slow.next;
            if(fast== slow){
                return true;
            }

        }
        return false;
    }

}
