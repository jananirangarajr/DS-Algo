package leet.Neetcode.dp;

public class LongestIncreasingSubSequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        //this works.. But more time consuming. O(n^2)
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 1;
        int globalMax = Integer.MIN_VALUE;

        for (int i = n-2; i >=0; i--){
            int curMax = 1;
            for (int j = i+1; j < n; j++){
                if (nums[i] < nums[j] && curMax < 1+dp[j])
                    curMax = 1+dp[j];
            }
            dp[i] = curMax;
            globalMax = Math.max(globalMax,curMax);
        }
        return globalMax == Integer.MIN_VALUE?1:globalMax;
    }
}
