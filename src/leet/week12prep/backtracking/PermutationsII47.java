package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>(),0 );
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> list,int index) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        else {
            for (int i = 0; i < nums.length;i++){
                if (i == index) continue;
                list.add(nums[i]);
                backtrack(nums,result,list,i);
                list.remove(list.size() - 1);
            }
        }
    }
}
