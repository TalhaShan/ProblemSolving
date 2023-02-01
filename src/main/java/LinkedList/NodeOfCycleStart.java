package LinkedList;

public class NodeOfCycleStart {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while (temp!=slow);
                break;
            }
        }
        ListNode first = head;
        ListNode second = head;
        while (length>0){
            second = second.next;
            length--;
        }
        while (first!=second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

}
