package leet.top150;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        List<Integer> array = new ArrayList<Integer>();
        return lengthOfList(nums,0,array,0,0,-1);
    }

    private static int lengthOfList(int[] nums, int count, List<Integer> array , int index,int lastAdded,int prev) {
        if (index == nums.length) {
//            if (count < array.size())
//                count = array.size();
            return count;
        }
        else {
            boolean isAdded = false;
            if (index == 0) {
//                array.add(nums[index]);
                lastAdded = nums[index];
                isAdded = true;
            }
            else if  (lastAdded < nums[index]) {
//                array.add(nums[index]);
                prev = lastAdded;
                lastAdded = nums[index];
                isAdded = true;
            }
            count = lengthOfList(nums,count,array,index+1,lastAdded,prev);
            if (lastAdded == nums[index] && isAdded)
                lastAdded = prev;
//                array.remove(array.size()-1);
            count = lengthOfList(nums,count, array, index+1,lastAdded,prev);
            return count;

        }
    }
}
