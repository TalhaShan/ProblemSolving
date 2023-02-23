package LinkedList;

public class RotateListByK {

    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || k  == 0){
            return head;
        }
        ListNode  current = head;
        int len = 1;
        while (current.next!=null){
            current = current.next;
            len++;
        }
        current.next  = head;  //make circular

        k  =   k%len;
        k  = len-k;
        while (k-->0) current  = current.next;
        head = current.next;
        current.next = null;


        return head;
    }
}
