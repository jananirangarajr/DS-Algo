package leet.Neetcode.linkedlist;

import java.sql.SQLOutput;

public class ReorderList143 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ListNode head = ListNode.createList(array);
        reorderList(head);
        ListNode.print(head);
    }
    public static void reorderList(ListNode head) {
        if (head.next == null)
            return;
        //find the middle
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow is preMiddle (an element before middle)
        //reverse the list from the middle to end
        ListNode prev = slow;
        ListNode current = slow.next;
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        slow.next.next = null;
        slow.next = prev;
//        ListNode.print(head);

        //merge the list from 0 - mid & mid to end
        ListNode node = head;
        ListNode mid = slow.next;
        while(mid != null){
            ListNode temp = node.next;
            node.next = mid;
            ListNode midTemp = mid.next;
            node.next.next = temp;
            mid = midTemp;
            if (mid == null)
                node.next.next = null;
            else
                node = temp;
        }

        //node.next = null;

    }
}
