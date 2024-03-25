package leet.week12prep.BinarySearch;

public class Peak162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int peak = nums[0];
        int peakIndex = 0;
        int low = 1, high = nums.length-1;

        while(low <= high){
            if (nums[low] > peak) {
                peak = nums[low];
                peakIndex = low;
            }
            if (nums[high] > peak){
                peak = nums[high];
                peakIndex = high;
            }
            high--;
            low++;
        }

        // for (int i = 1; i < nums.length; i++){
        //     if (nums[i] > peak){
        //         peak = nums[i];
        //         peakIndex = i;
        //     }
        // }
        return peakIndex;
    }
}
