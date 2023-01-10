package LinkedList;

public class DoublyLinkedList {

    private Node head;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void InsertLast(int val) {

        Node node = new Node(val);


        if (head == null) {
            node.prev = null;
            head = node;
            node.next = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
    }

    public void insertAfter(int after, int val) {
        Node p = find(after);
        if(p==null){
            System.out.println("Could not find");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next !=null){
            node.next.prev  =node;
        }
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if(node.val ==value){
                return node;
            }
            node = node.next;

        }
        return null;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;

        }
        System.out.println("END");
        System.out.println("Printing in Reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");

    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.InsertLast(100);
        list.insertAfter(8,65);
        list.display();



    }
}
