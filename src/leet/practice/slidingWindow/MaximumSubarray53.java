package leet.practice.slidingWindow;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        int nums[] = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++)
        {
            if (sum+nums[i] < nums[i]) {
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }
            max = Math.max(max,sum);
        }
        return max;

    }
}
