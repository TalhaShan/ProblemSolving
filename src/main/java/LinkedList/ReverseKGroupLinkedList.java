package LinkedList;


import java.util.Deque;
import java.util.Queue;

class ReverseKGroupLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode dummy  =  new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr  = dummy;
        ListNode  nxt =  dummy;
        int count = 0 ;
        while(curr.next!=null){
            curr = curr.next;
            count++;
        }
        while(count>=k){
            curr = pre.next;
            nxt =  curr.next;

            for(int i = 1; i<k; i++){
                curr.next =  nxt.next;
                nxt.next  = pre.next;
                pre.next  = nxt;
                nxt  = curr.next;
            }
            pre  = curr;
            count-=k;
        }
        return dummy.next;
    }

}
