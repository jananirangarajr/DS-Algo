package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII90 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,nums,new ArrayList<>(),0,new int[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int index,int[] added){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && added[i-1] == 0) continue;
            list.add(nums[i]);
            added[i] = 1;
            backtrack(result,nums,list,i+1,added);
            list.remove(list.size()-1);
            added[i] = 0;
        }
    }
}
