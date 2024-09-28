package STRIVER_SHEET.LinkedList;

public class IntersectionPoint {

    static int getDifference(Node head1,Node head2) {
        int len1 = 0,len2 = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                ++len1; head1 = head1.next;
            }
            if(head2 != null) {
                ++len2; head2 = head2.next;
            }

        }
        return len1-len2;//if difference is neg-> length of list2 > length of list1 else vice-versa
    }
    //utility function to check presence of intersection
    static Node intersectionPresent(Node head1,Node head2) {
        int diff = getDifference(head1,head2);
        if(diff < 0)
            while(diff++ != 0) head2 = head2.next;
        else while(diff-- != 0) head1 = head1.next;
        while(head1 != null) {
            if(head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;

    }
//    Solution 4: Optimised
//
//    Approach:
//
//    The difference of length method requires various steps to work on it. Using the same concept of difference of length, a different approach can be implemented. The process is as follows:-
//
//    Take two dummy nodes for each list. Point each to the head of the lists.
//    Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.

    //utility function to check presence of intersection
    static Node intersectionPresentOptimised(Node head1,Node head2) {
        Node d1 = head1;
        Node d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null? head2:d1.next;
            d2 = d2 == null? head1:d2.next;
        }

        return d1;
    }
}
