package leet.Neetcode.linkedlist;

public class FindDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        // for (int i = 0; i < nums.length; i++){
        //     int num = Math.abs(nums[i]);
        //     nums[num-1] = nums[num-1]*(-1);
        //     if (nums[num-1] > 0)
        //         return num;
        // }
        // return 0;
        //indexes represented as linked list and forms a cycle.

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int slow2 = 0;

        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        }while(slow != slow2);

        return slow;
    }
}
