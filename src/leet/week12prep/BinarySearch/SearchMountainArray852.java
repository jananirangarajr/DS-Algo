package leet.week12prep.BinarySearch;

public class SearchMountainArray852 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        System.out.println(peakIndexInMountainArray(nums));
    }
    public static int peakIndexInMountainArray(int[] nums) {

        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = (low+high)/2;

            if (nums[mid] < nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;

        // for (int i = 1; i < nums.length; i++){
        //     if (nums[i] > peak){
        //         peak = nums[i];
        //         peakIndex = i;
        //     }
        // }
//        return peakIndex;
    }
}
