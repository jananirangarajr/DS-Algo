package leet.top150;

import java.util.List;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        head.next = head1;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        else {
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow!= null && fast != null && slow != fast) {
                slow = slow.next;
                if (fast.next != null)
                    fast = fast.next.next;
                else
                    fast = null;
            }
            if (slow == fast)
                return true;
            return false;

        }

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode() {}

    public ListNode createList(int[] nums) {
        ListNode head = new ListNode();

        ListNode copy = head;
        copy.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            copy.next = new ListNode(nums[i]);
            copy = copy.next;
        }
        return head;
    }
}
