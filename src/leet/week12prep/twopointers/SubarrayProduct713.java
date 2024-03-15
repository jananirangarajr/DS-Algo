package leet.week12prep.twopointers;

public class SubarrayProduct713 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,5,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int start = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            product = product * nums[i];
            while (product >= k && start <= i) {
                product = product / nums[start++];
            }
            count += i - start+1;
        }
        return count;
    }
}
