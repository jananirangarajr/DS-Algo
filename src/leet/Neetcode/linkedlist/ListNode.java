package leet.Neetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

    ListNode (int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }

    public static ListNode createList(int[] array) {
        ListNode head = null;
        ListNode node = head;
        for (int x : array){
            if (head == null) {
                head = new ListNode(x);
                node = head;
            }
            else {
                node.next = new ListNode(x);
                node = node.next;
            }
        }
        return head;
    }

    public static void print(ListNode node){
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
