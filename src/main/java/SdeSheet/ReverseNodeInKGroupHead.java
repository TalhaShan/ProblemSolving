package SdeSheet;

import java.util.List;

public class ReverseNodeInKGroupHead {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr;
        ListNode nxt;
        while (count >=k) {
            curr = pre.next;
            nxt = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = curr.next;

            }
            count -= k;
            pre = curr;
        }
        return dummy.next;
    }
}
