package SdeSheet;

import java.util.List;
//THe difference is in reversing slow.next to revers or slow to reversed
public class PalindromeLinkedList {
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

    public boolean isPalindromeSde(ListNode head){
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast  = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
         slow = reverseNodes(slow);
         fast = head;
        while (slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            slow = slow.next;
            fast =fast.next;
        }
        return true;
    }

    private ListNode reverseNodes(ListNode head) {
       ListNode prev = null;
       while (head!=null){
           ListNode next = head.next;
           head.next = prev;
           prev = head;
           head = next;
       }
        return prev;
    }

    /* smae jsut change in reverse approach so slow.next
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if(head ==null || head.next==null){
                return true;
            }
            while (fast.next !=null && fast.next.next !=null){
                fast  = fast.next.next;
                slow =  slow.next;
            }
            slow.next = reverseList(slow.next);
            slow = slow.next;
            while (slow!=null){
                if(slow.val!= head.val)
                    return false;
                slow = slow.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head!=null){
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }
    }
     */


    /**** BRUTE FORCE APPROACH***/
/*
    class Node {
        int num;
        Node next;
        Node(int val) {
            num = val;
            next = null;
        }
    }
    class TUF{
        static Node insertNode(Node head,int val) {
            Node newNode = new Node(val);
            if(head == null) {
                head = newNode;
                return head;
            }

            Node temp = head;
            while(temp.next != null) temp = temp.next;

            temp.next = newNode;
            return head;
        }

        static boolean isPalindrome(Node head) {
            ArrayList<Integer> arr=new ArrayList<>();
            while(head != null) {
                arr.add(head.num);
                head = head.next;
            }
            for(int i=0;i<arr.size()/2;i++)
                if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
            return true;
        }

        public static void main(String args[]) {
            Node head = null;
            head=insertNode(head,1);
            head=insertNode(head,2);
            head=insertNode(head,3);
            head=insertNode(head,2);
            head=insertNode(head,1);
            if(isPalindrome(head)==true)
                System.out.println("True");
            else
                System.out.println("False");

        }
    }
    */
}
