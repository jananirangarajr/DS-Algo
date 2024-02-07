package leet.top150;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static void main(String[] args) {
        int [] nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        if (nums.length == 1){
            result.add(nums[0]+"->"+nums[0]);
            return result;
        }
        String s = nums[0] + "->";
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] != 1) {
                if (lastIndex == i-1)
                    s = String.valueOf(nums[lastIndex]);
                else
                    s += nums[i-1];
                result.add(s);
                s = nums[i]+"->";
                lastIndex = i;
            }
        }
        if (lastIndex == nums.length-1)
            s = String.valueOf(nums[lastIndex]);
        else
            s += nums[nums.length-1];
        result.add(s);
        return result;
    }
}
