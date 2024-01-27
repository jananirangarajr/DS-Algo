package leet.top150;

//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2};
        int val = 3;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        System.out.println(k);
        for (int num : nums)
            System.out.print(" "+num);
    }
}
