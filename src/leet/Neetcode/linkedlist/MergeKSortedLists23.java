package leet.Neetcode.linkedlist;

import java.util.List;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        int[] array1 = {2};
        int[] array2 = {-1};
        ListNode l1 = ListNode.createList(array1);
        ListNode l2 = ListNode.createList(array2);
        ListNode[] lists = {l1,null,l2};
        ListNode result = mergeKLists(lists);
        ListNode.print(result);

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        ListNode result = new ListNode();
        ListNode head = result;

        for (int i = 0; i < lists.length; i++){
            ListNode l1 = result;
            ListNode l2 = lists[i];
            result = mergeList(l1,l2);
        }
        return head.next;

    }

    private static ListNode mergeList(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode head = result;

        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                ListNode temp = l2.next;
                l2.next = null;
                result.next = l2;
                result = result.next;
                l2 = temp;
            }
            else{
                ListNode temp = l1.next;
                l1.next = null;
                result.next = l1;
                result = result.next;
                l1 = temp;
            }
        }
        if (l1 != null)
            result.next = l1;
        if (l2 != null)
            result.next = l2;
        return head.next;
    }
}
