package leet.Neetcode.linkedlist;

import javax.swing.*;
import java.util.List;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        ListNode head = ListNode.createList(array);

        //iterative way
        ListNode prev = null;
        ListNode current = head;
         while(current != null){
             ListNode temp = current.next;
             current.next = prev;
             prev = current;
             current = temp;
         }

        ListNode.print(prev);

         //recursive way
        head = reverseListRecursive(prev,null);
        ListNode.print(head);
    }
    private static ListNode reverseListRecursive(ListNode head, ListNode prev){
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseListRecursive(next,head);
    }
}
