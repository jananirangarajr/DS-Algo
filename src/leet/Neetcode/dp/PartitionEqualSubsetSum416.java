package leet.Neetcode.dp;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {5,5,11,1}));
    }
    public static boolean canPartition(int[] nums) {
        if (nums.length == 1)
            return false;
        if (nums.length == 2)
            return nums[0] == nums[1];

        int sum = 0;
        for (int x : nums)
            sum+= x;
        if (sum %2 != 0)
            return false;

        Set<Integer> dp = new HashSet<Integer>();
        dp.add(0);

        int target = sum / 2;

        for (int i = nums.length-1; i >= 0; i--){

            Set<Integer> copy = new HashSet<Integer>();

            for (int x : dp){
                if (target == nums[i]+x)
                    return true;
                copy.add(nums[i]+x);
            }
            dp.addAll(copy);
        }
        return false;
    }
    
}
