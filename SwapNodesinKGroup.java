
//   Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (head != null) {
            ListNode groupHead = head;
            int count = 0;
            ListNode temp = head; 
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            if (count == k) {
                ListNode groupTail = temp; 
                head = groupHead;
                ListNode newGroupHead = reverseSublist(head, k);
                prevGroupTail.next = newGroupHead;
                prevGroupTail = groupHead;
                head = groupTail; 
            } else {
                prevGroupTail.next = groupHead;
                break; 
            }
        }

        return dummy.next;
    }

    private ListNode reverseSublist(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (k > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        return prev;
    }
    
    
    public static void main(String[] args) {
    Solution solution = new Solution();

    ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    int k1 = 2;
    ListNode result1 = solution.reverseKGroup(head1, k1);
    printLinkedList(result1); 

 
}

private static void printLinkedList(ListNode head) {
    ListNode current = head;
    while (current != null) {
        System.out.print(current.val + " -> ");
        current = current.next;
    }
    System.out.println("null");
}

    
}
