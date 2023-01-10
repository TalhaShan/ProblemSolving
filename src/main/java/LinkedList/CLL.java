package LinkedList;

public class CLL {

    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.size = 0;
    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if (tail == null) { // first item addedd
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void insertAtParticular(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);  //at point where to insert new node ko temp k next pr kardia now
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) { //there was only one element
            tail = null;
        }
        size--;
        return val;
    }

    public int removeLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int deleteAtParticular(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node previous= get(index-1);
        int val = previous.next.value;
        previous.next = previous.next.next;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public  Node getNodeByValue(int val){
        Node node = head;
        while (node!=null){
            if(node.value==val){
                System.out.println(node.value);
                return node;

            }
            node = node.next;
        }

        return null;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insertAtParticular(100, 3);
        list.display();
        System.out.println();
        list.deleteFirst();
        list.display();
        System.out.println();
        System.out.println(list.removeLast());
        list.display();
        System.out.println();
        System.out.println(list.deleteAtParticular(2));

        list.display();
        System.out.println();
        System.out.println(list.getNodeByValue(8));

    }


}
