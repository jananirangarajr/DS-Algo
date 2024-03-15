package leet.week12prep.twopointers;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int closestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                int difference = Math.abs(target-sum);
                if (difference <= closestDifference) {
                    closestDifference = difference;
                    closestSum = sum;
                }
                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }
}
