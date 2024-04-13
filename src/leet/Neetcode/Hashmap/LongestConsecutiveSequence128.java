package leet.Neetcode.Hashmap;

import java.util.HashMap;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                int left = map.containsKey(nums[i]-1)?map.get(nums[i]-1): 0;
                int right = map.containsKey(nums[i]+1)?map.get(nums[i]+1): 0;
                int sum = left+right+1;
                result = Math.max(result, sum);
                map.put(nums[i],sum);
                //change the boundary values
                map.put(nums[i]-left,sum);
                map.put(nums[i]+right,sum);
            }
        }
        return result;
    }
}
