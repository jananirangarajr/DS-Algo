package leet.week12prep.greedy;

public class ShortestUnsortedContinuousSubarray581 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,2,2,3,2};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > nums[i]){
                if (startIndex == -1){
                    startIndex = i-1;
                }
                endIndex = i;
            }
            if (endIndex != -1 && i > endIndex && nums[i] == nums[endIndex])
                endIndex = i;
        }
        return startIndex == endIndex?0:endIndex-startIndex+1;
    }
}
