import java.util.*;
public class RemoveDuplicatesinLinkedList {
    
    class Node{
        int data;
        Node next;
    }

    private Node head;
    private int size;
    HashSet<Integer> s = new HashSet<Integer>();

    public void insertNode(int val) {
        if(head == null) {
            Node n = new Node();
            n.data = val;
            head = n;
            head.next=null;
        }
         else {
            Node cur = head;
            Node n = new Node();
            n.data = val;
            while( cur.next != null)
                cur = cur.next;
            cur.next = n;
            n.next = null;
         }
         size+=1;
    }

    //Using nested loops
    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node cur = head;
        while (cur != null) {
            Node temp = cur;
            while (temp.next != null) {
                if (temp.next.data == cur.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
    }

    //Using Hashset
    public void removeDuplicateswithHashset() {
        if (head == null) {
            return;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (s.contains(temp.data)) {
                prev.next = temp.next;
            } else {
                s.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
    }

    
    public void display(){
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesinLinkedList r = new RemoveDuplicatesinLinkedList();
        r.insertNode(1);
        r.insertNode(2);
        r.insertNode(2);
        r.insertNode(4);
        r.insertNode(4);
        r.insertNode(5);
        r.insertNode(6);
        r.insertNode(1);
        r.insertNode(3);
        r.insertNode(5);
        r.display();

        System.out.println("After removing duplicates: ");
        r.removeDuplicates(); 
        // r.removeDuplicateswithHashset();
        r.display();
    }
}
