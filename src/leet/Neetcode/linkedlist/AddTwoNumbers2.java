package leet.Neetcode.linkedlist;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        int[] array = {1,3,5};
        int[] array1 = {5,6,7};

        ListNode l1 = ListNode.createList(array);
        ListNode l2 = ListNode.createList(array1);
        ListNode result = addTwoNumbers(l1,l2);
        ListNode.print(result);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // int multiplicant = 1;
        // long value1 = 0;
        // while(l1 != null){
        //     value1 += (l1.val*multiplicant);
        //     multiplicant *= 10;
        //     l1 = l1.next;
        // }
        // long value2 = 0;
        // multiplicant = 1;
        // while(l2 != null){
        //     value2 += (l2.val*multiplicant);
        //     multiplicant *= 10;
        //     l2 = l2.next;
        // }
        // // System.out.println(value1+" "+value2);
        // long sum = value1 + value2;
        // // System.out.println(sum);
        // if (sum == 0)
        //     return new ListNode(0);

        // ListNode head = null;
        // ListNode copy = head;
        // while(sum > 0){
        //     ListNode node = new ListNode((int)sum%10);
        //     sum = sum/10;
        //     if (head == null){
        //          head = node;
        //          copy = head;
        //     }
        //     else{
        //         copy.next = node;
        //         copy = node;
        //     }
        // }

        // return head;
        //above method fail for the case that is out of range of integer or long. eg: l2 = [1,9,9,9,9,9,9,9,9,9] l1 = [9]
        int carry = 0;
        ListNode head = null;
        ListNode result = null;
        while(l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                value2 = l2.val;
                l2 = l2.next;
            }
            int sum = value1+value2+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            if (head == null){
                head = node;
                result = head;
            }
            else {
                head.next = node;
                head = head.next;
            }


        }
        if (carry != 0){
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        return result;
    }

}
