package SdeSheet;

import java.util.HashSet;

public class StartingPointOfLoopInLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }
    //T o(N)
    //s o(N)
    static Node detectCycleStartHashSet(Node head) {

        Node fast = head;
        Node slow = head;
        Node entry = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){//colided

                  while (entry!=slow){
                      slow  = slow.next;
                      entry = entry.next;
                  }
                  return slow;
            }
        }
        return null;
    }  //extra differnece coverred by fast
//L1 = nc - l2;
    //Note detection of cycle doesn;t mean it the starts of the loop
    //or collision point of fast and slow doesn;t mean it's the start of loop

    static Node detectCycleStart(Node head) {
        HashSet<Node> st=new HashSet<>();
        while(head != null) {
            if(st.contains(head)) return head;
            st.add(head);
            head = head.next;
        }
        return null;
    }

}

