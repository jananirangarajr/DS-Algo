package leet.week12prep.slidingwindow;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,-1};
        int k = 1;
        int[] result = maxSlidingWindow(nums,k);
        for (int x: result)
            System.out.print(x+" ");
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int start = 0, end = 0, max = nums[0], maxIndex=0;
        int len = nums.length;
        int[] result = new int[len-(k-1)];

        for (;end < k; end++ ) {
            if (max <= nums[end]){
                max = nums[end];
                maxIndex = end;
            }
        }
        if (end == len) {
            result[start] = max;
            return result;
        }
        while(end < len) {
            System.out.println(max+" "+maxIndex+" "+start+" "+end);
            result[start] = max;
            start++;
            if (maxIndex < start) {
                //iterate throught the values from start+1 to end and find max
                for (int i = start; i < end; i++){
                    max = Integer.MIN_VALUE;
                    if (max < nums[i]){
                        max = nums[i];
                        maxIndex = i;
                    }
                }
            }
            if (max <= nums[end]){
                max = nums[end];
                maxIndex = end;
            }

            end++;
        }
        result[start] = max;
        return result;
    }
}
