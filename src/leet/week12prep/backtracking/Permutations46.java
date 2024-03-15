package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = new int[0];
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,result,new ArrayList<>());
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        if (list.size() == nums.length)
        {
            result.add((List<Integer>) list.clone());
            return;
        }
        else {
            for (int i = 0; i < nums.length; i++){
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                permute(nums,result,list);
                list.remove(list.size()-1);
            }
        }
        return;
    }
}
