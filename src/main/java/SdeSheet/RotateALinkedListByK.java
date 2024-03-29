package SdeSheet;


public class RotateALinkedListByK {

    public class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static Node rotateRightBrute(Node head, int k) {
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {  //lets say k= 1 , if we have 1->2->3->4->5->NULL then after k=1 ,  5->1->2->3->4-> NULL
            Node temp = head;   //takes temp on head
            while (temp.next.next != null) temp = temp.next;  //this will stop at 4
            Node end = temp.next;  //make 5 as end node
            temp.next = null; // 4 point to null as we want
            end.next = head; // 5 the end point to head as we want
            head = end;   // make 5 head
        }
        return head;
    }


//        1->2->3->4->5
//               if k =2
//        5->1->2->3->4-> NULL  // k=1
//        4->5->1->2->3->NULL        // k=2

    //so if we notice  its already reversed only 4 becomes head and 3 point to  null for k=2
    //how to reach 3 in case k =12  5%12 = 2 then
    //len -k again gives =  5-2 =3 so if you notice we want o point 3 to null
    //steps
    //got length , make circular, got where to point null, make next of it head

    static Node rotateRightOptimal(Node head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        Node current = head;
        int len = 1;
        while (current.next != null) {
            current = current.next;
            len++;
        }
        k = len % k; // like if we got multiple 5 10 15 is becoming to its original state
        current.next = head;
        k = len - k;
        while (k-- > 0) {
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;
    }
}
