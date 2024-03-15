package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //subsets(result,nums,new ArrayList<Integer>(),0);
        if (nums == null)
            return result;
        subsets(result,nums,new ArrayList<Integer>(),0);
        //result.add(new ArrayList<>());
        return result;
    }

    private static void subsets(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int index) {
        /*if (index == nums.length)
            return;
        list.add(nums[index]);
        subsets(result,nums,list,index+1);
        result.add((List<Integer>) list.clone());
        list.remove(list.size()-1);
        subsets(result,nums,list,index+1);
        return;*/
//the above code and the below code are same and generate same results.
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
