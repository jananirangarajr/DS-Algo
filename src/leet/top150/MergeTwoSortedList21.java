package leet.top150;

public class MergeTwoSortedList21 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        list1 = list1.createList(new int[] {-9,-7,-6,-1,0,1,2,4,7});
        list2 = list2.createList(new int[] {-10,-6,4,6,8});

        ListNode result = mergeTwoLists(list1,list2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else {
            /*ListNode head;
            ListNode prev;
            if (list1.val > list2.val) {
                head = list2;
                prev = list2;
                list2 = list2.next;
            }
            else {
                head = list1;
                prev = list1;
                list1 = list1.next;
            }
            while (list1 != null && list2 != null){
                if (list1.val >= list2.val) {
                    prev.next = list2;
                    list2 = list2.next;
                    prev = prev.next;
                    prev.next = list1;
                }
                else {
                    prev = list1;
                    list1 = list1.next;
                }
            }
            if (list2 != null)
                prev.next = list2;
            if (list1 != null)
                prev.next = list1;
            return head;

        }
*/
            // above approach didn't work because of the prev node mismatch happening and losing the track
            ListNode node = new ListNode();
            ListNode currentNode = node;

            while (list1 != null && list2 != null)
            {
                if (list1.val < list2.val) {
                    currentNode.next = list1;
                    list1 = list1.next;
                } else {
                    currentNode.next = list2;
                    list2 = list2.next;
                }
                currentNode = currentNode.next;
            }
            if (list1 != null)
                currentNode.next = list1;
            if (list2 != null)
                currentNode.next = list2;
            return node.next;
        }
    }
}
