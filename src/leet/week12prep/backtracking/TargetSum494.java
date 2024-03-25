package leet.week12prep.backtracking;

import java.util.Stack;

public class TargetSum494 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int result = 0;
//        result = backtrack(result,0,nums,target,0);
        result = backtrack(0,nums,target,0);
        return result;
    }
    private static int backtrack(int sum, int[] nums, int target, int index) {
        if (sum == target && index == nums.length) {
            return 1;
        }
        else if (index == nums.length)
            return 0;
        else {
            int add = backtrack(sum+nums[index],nums,target,index+1);
            int sub = backtrack(sum-nums[index],nums,target,index+1);
            return add+sub;
        }
    }
    /*private static int backtrack(int result, int sum, int[] nums, int target, int index) {
        if (sum == target && index == nums.length) {
            System.out.println("\n result added");
            result += 1;
            return result;
        }
        else if (index == nums.length)
            return result;
        else {
            for (int i = index; i < nums.length;i++) {
                System.out.print(" + "+nums[i]+"("+i+")");
                sum+= nums[i];
                result = backtrack(result,sum,nums,target,i+1);
                sum -= nums[i];
                System.out.println();
                System.out.print(" - "+nums[i]+"("+i+")");
            }
            System.out.println("\n result "+result);
            return result;
        }
    }*/
}
