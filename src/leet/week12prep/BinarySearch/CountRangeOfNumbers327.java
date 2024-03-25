package leet.week12prep.BinarySearch;

public class CountRangeOfNumbers327 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,5,-1};
        int lower = -2;
        int upper = 2;
        System.out.println(countRangeSum(nums,lower,upper));
    }
    public static int countRangeSum(int[] nums, int lower, int upper) {
        return countRangeSum(nums,lower,upper,0,0);
    }

    private static int countRangeSum(int[] nums, int lower, int upper, int sum,int index) {
        /*if (index >= nums.length)
        {
            if (sum >= lower && sum <= upper)
                return 1;
            return 0;
        }
        else {
            int count = 0;
            for (int i = index; i < nums.length; i++){
                sum = sum+nums[i];
                count += countRangeSum(nums,lower,upper,sum,i+1);
                sum = sum-nums[i];
            }
            return count;
        }*/
        int count = 0;
        if (index >= nums.length) {
            return 0;
        }
        for (int end = index; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= lower && sum <= upper) {
                count++;
            }
            count += countRangeSum(nums, lower, upper, sum, end + 1);
            sum -= nums[end]; // reset sum for the next iteration
        }
        return count;

    }
}
