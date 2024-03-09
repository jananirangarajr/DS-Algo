package leet.week12prep.slidingwindow;

public class MinSizeSubArraySum209 {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = new int[] {5,1,3,5,10,7,4,9,2,8};
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, sum = 0, minLen = Integer.MAX_VALUE;

        if (nums[0] == target)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target){
//            if (sum >= target){
                minLen = Math.min(minLen,(i-start+1));
                sum -= nums[start];
                start++;
            }
        }
//        while(start < nums.length && sum >= target) {
//            sum -= nums[start];
//            if (sum >= target) {
//                minLen = Math.min(minLen,nums.length-start);
//            }
//        }
        //above loop fails when middle 2 nos add upto sum [5,1,3,5,10,7,4,9,2,8] target = 15
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}
