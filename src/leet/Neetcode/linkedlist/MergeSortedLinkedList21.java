package leet.Neetcode.linkedlist;

public class MergeSortedLinkedList21 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {4,5,6};
        ListNode list1 = ListNode.createList(array1);
        ListNode list2 = ListNode.createList(array2);
        ListNode.print(mergeTwoLists(list1,list2));
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode result = new ListNode();
        ListNode rc = result;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                rc.next = list1;
                list1 = list1.next;
            }
            else{
                rc.next = list2;
                list2 = list2.next;
            }
            rc = rc.next;
            rc.next = null;
        }
        if (list1!= null)
            rc.next = list1;
        if (list2 != null)
            rc.next = list2;
        return result.next;
    }
}
