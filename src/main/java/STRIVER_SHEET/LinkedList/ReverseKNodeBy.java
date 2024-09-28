package STRIVER_SHEET.LinkedList;

public class ReverseKNodeBy {
    static Node kReverse(Node head, int k) {
        Node temp = head;
        Node prevNode = null;

        while (temp != null) {

            Node kthNode = getthKNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedlist(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;

        }

        return head;


    }

    static Node reverseLinkedlist(Node head) {
        // Initialize'temp' at
        // head of linked list
        Node temp = head;

        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        Node prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while(temp != null){
            // Store the next node in
            // 'front' to preserve the reference
            Node front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }

        // Return the new head of
        // the reversed linked list
        return prev;

    }

    private static Node getthKNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k >= 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
}
