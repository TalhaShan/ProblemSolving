package LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode node) {
        ListNode head = node;
        if(node == null){
            return node;
        }
        while(node.next!=null){
            if(node.val == node.next.val){
                node.next = node.next.next;

            }else{
                node = node.next;
            }
        }
        return head;
    }
}
