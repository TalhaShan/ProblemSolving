package NeetCode150;

public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {

        if(head == null){
            return;
        }

        ListNode slow = head,  fast = head;

        //Finding middle keep i.e beware of && is imp
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode prev = null, curr = slow, temp;

        //Slow(head) gives us middle
        //Now we need to reverse from middle i.e slow
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;
        //Now we have 2 ll now we need to merge one from first one from second until second one is null
        //second one is half from middle and its reversed
        while (second.next != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
