package SdeSheet;


import java.util.List;

public class RemoveNthNodeFromBack {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Input: head = [1,2,3,4,5], n = 2
    //Output: [1,2,3,5]
    //1->2->3->4->5
    //1->2->3->5
//S o(1)
    //T(2N)
    //Approach 1:
    //1. Count the total nodes in this example :  5
    //then to calculate = total - node to remove; 5-2 = 3
    //as we got 3 which mean we need to skip the node next to 3 and point 3 to next of next which is (5)
    static ListNode deleteNthNodeFromEnd(ListNode head, int n)
    {
        int Length = length(head);
        int nodeFromBeginning = Length - n + 1;
        ListNode prev = null;
        ListNode temp = head;
        for (int i = 1; i < nodeFromBeginning; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (prev == null) { //edge case delete head
            head = head.next;
            return head;
        }
        else {
            prev.next = prev.next.next;
            return head;
        }
    }
    static int length(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    //APPROACH 2 FAST AND SLOW POINTER
    //S O(1)
    //T O(N)
//When you move the fast pointer to nth node, the remaining nodes to traverse is (size_of_linked_list - n).
// After that, when you start moving slow pointer and fast pointer by 1 node each,
// it is guaranteed that slow pointer will cover a distance of (size_of_linked_list - n) nodes .
// And that's node we want to remove. as we saw in first approach // length-n
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode  slow =  start;
        ListNode fast  = start;
        for(int i = 1; i<= n; i++){
            fast = fast.next;
        }

        while (fast.next!=null){
            fast= fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }
    static void printList(ListNode head)
    {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Linked List before Deletion:");
        printList(head);

        head = deleteNthNodeFromEnd(head, 5);

        System.out.println("Linked List after Deletion:");
        printList(head);
    }
}
