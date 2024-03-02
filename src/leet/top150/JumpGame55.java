package leet.top150;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGame55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        //return canJump(nums, 0);
        // kadane's algorithm, Calculate reach at every index and compare with the last max reach. Always take the maxReach from both
        int reach = 0;
        for (int index = 0; index < nums.length; index++) {
            if (reach < index)
                return false;
            reach = Math.max(reach, index+nums[index]);
        }
        return true;
    }

    private static boolean canJump(int[] nums, int index) {
        /* always find max values from the reach possible and jump there. Greedy
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
            //logic fails when the input is 4 2 0 0 1 6
            */

        /* Calculate if reach possible for every index
        if (nums[index] == 0)
            return false;
        if (index >= nums.length - 1 || index + nums[index] >= nums.length - 1)
            return true;
        for (int i = (index + 1); i <= (index + nums[index]) && i < nums.length; i++) {
            return canJump(nums, i))
        }
        return false;*/
        //can be modified with DP
        /* Calculate if reach possible for every index and store the result to optimize overlapping sub problem
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return canJump(nums,index,dp);*/
        return false;
    }

    private static boolean canJump(int[] nums, int index, int[] dp) {
        if (nums[index] == 0)
            return false;
        if (index >= nums.length - 1 || index + nums[index] >= nums.length - 1)
            return true;
        if (dp[index] != -1)
            return dp[index] != -1;
        for (int i = (index + 1); i <= (index + nums[index]) && i < nums.length; i++) {
            if (canJump(nums, i)) {
                 dp[index] = 1 ;
                 return dp[index] != -1;
            }
        }
        dp[index] = -1;
        return dp[index] != -1;
    }

}
