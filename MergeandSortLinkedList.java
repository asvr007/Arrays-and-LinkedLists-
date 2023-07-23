public class MergeandSortLList {
    
    class Node {
        int data;
        Node next;   
    }
 
    public Node newLinkedList(int n) {
        Node head = new Node();
        head.data = n;
        head.next = null;
        return head;
    }

    public void insertNode(Node head, int n) {
        Node cur = head;
        while(cur.next != null) 
            cur = cur.next;
        Node temp = new Node();
        temp.data = n;
        temp.next = null;
        cur.next = temp;
    }

    public void merge(Node head1, Node head2) {
        Node cur = head1;
        while(cur.next != null) 
            cur = cur.next;
        cur.next = head2;
    }

    //using bubble sort
    public void bubbleSort(Node head) {
        Node cur = head;
        while(cur != null) {
            Node temp = cur.next;
            while(temp != null) {
                if(cur.data > temp.data) {
                    int t = cur.data;
                    cur.data = temp.data;
                    temp.data = t;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    public void display(Node head){
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    
    public static void main(String[] args) {
        MergeandSortLList m = new MergeandSortLList();
        Node head1 = m.newLinkedList(5);
        Node head2 = m.newLinkedList(2);

        m.insertNode(head1, 21);
        m.insertNode(head1, 1);
        m.insertNode(head1, 44);

        m.insertNode(head2, 67);
        m.insertNode(head2, 7);
        m.insertNode(head2, 12);

        m.merge(head1, head2);
        m.bubbleSort(head1);

        m.display(head1);
    }
}
