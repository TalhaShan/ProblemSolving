package STRIVER_SHEET.LinkedList;


import java.util.List;

public class MergeTwoSortedLinkedList {
    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyhead = new ListNode();
        ListNode tail = dummyhead;
/*
dummyhead is created as a new ListNode with no initial value. It acts as a dummy node at the start of the merged list.
tail is a pointer that initially points to dummyhead. It is used to build the merged list by attaching nodes to it.
 */
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }

            tail.next = (list1 != null) ? list1 : list2;
        }
        return dummyhead.next;
    }

    //Space O(1) // IN PLACE MERGE


    public ListNode mergeTwoListsOptimal(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        //Our goal is to keep l1 be the list that has smaller value.
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode res = list1;
        while (list1 != null && list2 != null) {
            ListNode temp = null;
            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;

            //making l1 the small
            ListNode tmp = null;
            tmp = list1;
            list1 = list2;
            list2 = tmp;

        }

        return res;
    }

}
