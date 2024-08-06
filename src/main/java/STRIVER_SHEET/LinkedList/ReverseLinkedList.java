package STRIVER_SHEET.LinkedList;

public class ReverseLinkedList {
    public Node reverseList(Node head) {
        Node dummy = null;
        while (head != null) {
            Node next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
