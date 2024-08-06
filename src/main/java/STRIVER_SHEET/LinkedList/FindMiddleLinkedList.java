package STRIVER_SHEET.LinkedList;


public class FindMiddleLinkedList {
    static Node findMiddle(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        temp = head;
        int mid = count / 2 + 1;
        while (temp != null) {
            mid = mid - 1;
            if (mid == 0) {
                break;
            }
            temp = temp.next;

        }
        return temp;
    }

    static Node findMiddleOptimal(Node head) {

        if (head == null || head.next == null) return head;

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

