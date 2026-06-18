package NeetCode150;



public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode dummy = head;

        int carry = 0;
        while (l1 != null || l2 != null ) {
            int sum = 0+ carry;

            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            carry = sum/10;  //gives 1 or 0
            sum = sum%10;  //given you the last one to add to list
            dummy.next = new ListNode(sum);
            dummy = dummy.next;

        }
        if(carry!=0){
            dummy.next = new ListNode(carry);
        }

        return head.next;
    }
}
