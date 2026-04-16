package NeetCode150;

public class MinStack {

    private Node head;
    public MinStack() {

    }

    public void push(int val) {

        if(head==null){
            //very first time
            head = new Node(val,val,null);
        }
        else {
            head =  new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;  //had it every stage min value
    }

    public class Node {
        int min;
        int val;
        Node next;

        Node( int val, int min ,Node next){
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }
}
