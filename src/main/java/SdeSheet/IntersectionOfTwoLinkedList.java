package SdeSheet;

public class IntersectionOfTwoLinkedList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    //Approach 1 count length of both List for EX: A= 5 B =7
    //take diff  =   7-5 = 2
    //now move longer one 2 steps ahead;
    //then start traversing both if met return , either intersection or at null
    //Summary
    //Find the length of both lists.
    //Find the positive difference between these lengths.
    //Move the dummy pointer of the larger list by the difference achieved. This makes our search length reduced to a smaller list length.
    //Move both pointers, each pointing two lists, ahead simultaneously if both do not collide.
//   T O(2max(length of list1,length of list2))+O(abs(length of list1-length of list2))+O(min(length of list1,length of list2))

    //Approach 2 modified version of approach 1 T O(2M) //same

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode dummy_A =  headA;
        ListNode dummy_B=headB;
        while (dummy_A!=dummy_B){
            if(dummy_A==null){
                dummy_A= headB;
            }else {
                dummy_A = dummy_A.next;
            }

            if(dummy_B==null){
                dummy_B= headA;
            }else {
                dummy_B = dummy_B.next;
            }
        }


        return dummy_A;  //if loops break either found intersection or not (means both met at null)
    }

}
