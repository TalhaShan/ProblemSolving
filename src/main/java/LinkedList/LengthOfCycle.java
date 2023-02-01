package LinkedList;

public class LengthOfCycle {

    public int cycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int count = calculateCount(fast, slow);
                return count;
            }

        }
        return 0;
    }


    public int cycleLengthBetter(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int count = 0;
                do {
                    temp = temp.next;
                    count++;
                } while (temp != slow);
                return count;
            }

        }
        return 0;
    }


    private int calculateCount(ListNode fast, ListNode slow) {
        int count = 0;
        while (slow.next != fast) {
            slow = slow.next;
        }
        return count + 1;
    }

}
