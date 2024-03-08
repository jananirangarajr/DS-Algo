package leet.top150;

public class MaximumAverageSubArrayI643 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        //sliding window technique
        double sum = 0;
        for (int i = 0 ;i < k; i++){
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            max = Math.max(max,sum);
        }
        System.out.println(max/k);
    }
}
