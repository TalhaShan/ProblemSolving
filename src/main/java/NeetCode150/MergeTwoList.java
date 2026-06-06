package NeetCode150;

public class MergeTwoList {
      public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode merge = dummyhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merge.next = list1;
                list1 = list1.next;
                merge = merge.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
                merge = merge.next;
            }
        }
        merge.next = (list1 != null) ? list1 : list2;

        return dummyhead.next;
    }
}
