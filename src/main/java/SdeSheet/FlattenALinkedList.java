package SdeSheet;

public class FlattenALinkedList {

    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    Node merge(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.down = a;
                temp = temp.down;
                a = a.down;
            } else {
                temp.down = b;
                temp = temp.down;
                b = b.down;
            }
        }
        temp.down = a != null ? a : b;
//        if (a != null) {
//            temp.down = a;
//        } else {
//            temp.down = b;
//        }
        return res.down;
    }

    Node flatten(Node root) {
        if (root == null || root.right == null) {
            return root;
        }

        root.right = flatten(root.right);

        root = merge(root, root.right);

        return root;

    }
}
