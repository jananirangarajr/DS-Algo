package leet.Neetcode.dp;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        /*
        //doesn't work for inputs like {-2,2,-4}
        int n = nums.length;
        int[] result = new int[n];
        result[n-1] = nums[n-1];
        int globalMax = result[n-1];
        for (int i = n-2; i >= 0 ; i--){
            result[i] = Math.max(nums[i], nums[i]*nums[i+1]);
            globalMax = Math.max (globalMax,result[i]);
        }
        return globalMax;*/
        int result = Integer.MIN_VALUE;
        int curMax = 1, curMin = 1;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {
                //edge case
                curMin = 1;
                curMax = 1;
            }
            int temp =curMax * nums[i];
            curMax = Math.max(nums[i], Math.max(curMax*nums[i], curMin*nums[i]));
            curMin = Math.min(nums[i], Math.min(temp, curMin*nums[i]));
            result = Math.max(result, Math.max(curMax,curMin));
        }
        return result;
    }
}
