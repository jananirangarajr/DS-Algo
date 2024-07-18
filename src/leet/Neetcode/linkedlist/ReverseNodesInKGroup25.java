package leet.Neetcode.linkedlist;

public class ReverseNodesInKGroup25 {
    public static void main(String[] args) {
        int[] array =  {1,2,3,4,5};
        ListNode head = ListNode.createList(array);
        ListNode result = reverseKGroup(head,2);
        ListNode.print(result);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        ListNode prev = new ListNode();
        ListNode result = prev;
        ListNode current = head;
        while(true) {
            int i = 1;
            //offset
            while( i <= k && fast != null){
                fast = fast.next;
                i++;
            }
            if (i > k) {
                while(current != null && current != fast) {
                    ListNode temp = current.next;
                    current.next = prev;
                    prev = current;
                    current = temp;
                }

            }
            else if ( i > 0){
                prev.next = current;
                break;
            }
            else
                break;


        }
        return result;
    }
}
