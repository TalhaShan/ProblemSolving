package LinkedList;


import java.util.List;

public class RemoveNthNodeFromReversePractice {
    public static class ListNode {
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

    static ListNode deleteNthNodeFromEnd(ListNode head, int n) {
        int len =0;
        ListNode  temp = head;
        while (temp!=null){
            len++;
            temp = temp.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 0 ; i < len-n; i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev==null){
            head = head.next;
            return head;
        }else {
            prev = prev.next.next;
        }
        return head;
    //O(2n) traversing twice
    }

    static ListNode deleteNthNodeFromEndOptimal(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;

        ListNode slow = start;
        ListNode fast = start;
        for(int i = 0 ; i <n; i++){
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow = slow.next.next;
        return start.next;
    }
    }