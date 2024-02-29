package leet.top150;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private static boolean canJump(int[] nums, int index) {
        if (nums[index] == 0)
            return false;
        if (index >= nums.length - 1 || index + nums[index] >= nums.length - 1)
            return true;
        else {
            int max = 0;
            int maxIndex = index + 1;
            for (int i = (index + 1); i <= (index + nums[index]) && i < nums.length; i++) {
                if (max <= nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return canJump(nums, maxIndex);
        }
    }
}
