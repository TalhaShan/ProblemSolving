package Nov;

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

        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                current.next = list1;
                list1 = list1.next;

            } else if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
//             list2.val<list1.val
                current.next = list2;
                list2 = list2.next;

            }
            current = current.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
