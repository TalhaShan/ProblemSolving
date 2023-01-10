package LinkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {

        this.head = null;
        this.tail = null;
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public void insert(int val){
       //we do isnertion after tail in circular linked list or before head
        Node node = new Node(val);
        if (head==null){
            head=node;
            tail =node;
            return;
        }
        tail.next =  node;
        node.next =head; //added after tail and before head
        tail = node;
    }
    public void delete(int value) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.val == value) {  //actually deleting the head so make new node head;
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if (n.val == value) {
                node.next = n.next;
                break;
            }
            node = node.next;
        }
            while (node != head) ; //complete round trip


    }

    public void display(){
        Node node = head;
        if(head!=null){
            do {
                System.out.print(node.val+" -> ");
                node = node.next;
            }while (node!=head);
        }
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(3);
        list.insert(2);
        list.insert(8);
        list.insert(17);
        list.insert(99);
        list.display();
        list.delete(8);
        System.out.println("Deleting");
        list.display();
    }
}
