package leet.Neetcode.linkedlist;

public class RemoveNthNodefromList19 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ListNode head = ListNode.createList(array);
        ListNode.print(removeNthFromEnd(head,3));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /* Works good. But the array is modified
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
        int deleteNode = count - n;
        if (deleteNode == 0)
            return head.next;
        int i = 1;
        node = head;

        while(i < deleteNode){
            node = node.next;
            i++;
        }
        node.next = node.next.next;

        return head;*/
        //Without Modifying the array
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;

        //iterate for n nodes
        while (n > 0){
            fast = fast.next;
            n--;
        }
        //now iterate the both the fast and slow pointer as the offset between them is n(n+1 actually, to make next pointer correct position)
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
