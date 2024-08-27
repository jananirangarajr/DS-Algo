package leet.Neetcode.dp;

public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        return Math.max(rob(0,nums.length-1,nums),rob(1,nums.length,nums));

/*
        if (nums.length == 1)
            return nums[0];
        int rob1 = 0;
        int rob2 = 0;
        int n_3Value = 0;
        int thirdValue = 0;
        int n = nums.length;
        for (int i = n-2; i >= 1; i--){
            int temp = Math.max(nums[i]+rob1,rob2);
            if (i == n-3)
                n_3Value = temp;
            if (i == 2)
                thirdValue = temp;
            rob1 = rob2;
            rob2 = temp;
        }
        rob2 = Math.max(rob2, thirdValue+nums[0]);
        rob2 = Math.max(rob2, Math.max(nums[n-2],nums[n-1]+n_3Value));
        return rob2;
*/

    }

    private static int rob(int startIndex, int endIndex, int[] nums){
        int rob1 = 0, rob2 = 0;

        for (int i = startIndex; i < endIndex; i++){
            int temp = Math.max(nums[i]+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
