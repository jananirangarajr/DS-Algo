package leet.Neetcode.dp;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {

        //edge cases => n-1, n-2
        // if (nums.length ==1)
        //     return nums[0];
        // int n = nums.length;
        // int maxCost = Math.max(nums[n-1],nums[n-2]);
        // for (int i = n-3; i >=0; i--){
        //    int cost = nums[i];
        //    for (int j = i+2; j < nums.length; j++){
        //         cost = Math.max(cost, nums[i]+nums[j]);
        //    }
        //    nums[i] = cost;
        //    maxCost = Math.max(cost, maxCost);
        // }

        // return maxCost;

        int rob1 = 0;
        int rob2 = 0;
        for (int i = nums.length-1; i >=0; i--){
            int temp = Math.max(rob1+nums[i],rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
