package STRIVER_SHEET.LinkedList;

public class IsPalindromeLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reversedLinkedList(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reversedLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;

        }
        reversedLinkedList(newHead);
        return true;
    }
    // Function to reverse a linked list
    // using the recursive approach
    public static Node reversedLinkedList(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {

            // No change is needed;
            // return the current head
            return head;
        }

        // Recursive step: Reverse the remaining
        // part of the list and get the new head
        Node newHead = reversedLinkedList(head.next);

        // Store the next node in 'front'
        // to reverse the link
        Node front = head.next;

        // Update the 'next' pointer of 'front' to
        // point to the current head, effectively
        // reversing the link direction
        front.next = head;

        // Set the 'next' pointer of the
        // current head to 'null' to
        // break the original link
        head.next = null;

        // Return the new head obtained
        // from the recursion
        return newHead;
    }
}
