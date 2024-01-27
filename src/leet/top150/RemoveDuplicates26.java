package leet.top150;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,2,2,5,5,5,5,6};
        int k = 0;
        for (int i = 1 ; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[k+1] = nums[i];
                k++;
            }
        }
        System.out.println(k+1);
        for (int num : nums) {
            System.out.print(" "+num);
        }
    }
}
