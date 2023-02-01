package LinkedList;

import java.util.List;

public class PalindromicLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head ==null || head.next==null){
            return true;
        }
        while (fast!=null && fast.next!=null){
            fast  = fast.next.next;
            slow =  slow.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while (slow!=null){
            if(slow.val!= head.val)
                return false;
        slow = slow.next;
        head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
       ListNode newHead = null;
       while (head!=null){
           ListNode next = head.next;
           head.next = newHead;
           newHead = head;
           head = next;
        }
        return newHead;
    }
}
