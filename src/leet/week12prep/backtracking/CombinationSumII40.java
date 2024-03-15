package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,candidates,target, new ArrayList<Integer>(),0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int[] candidates, int target, ArrayList<Integer> list,int index) {
        if (target < 0)
            return;
        else if (target == 0) {
//            if (!result.contains(list))
                result.add((List<Integer>)list.clone());
            return;
        }
        else {
            for (int i = index; i < candidates.length; i++){
                if (i > index && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                backtrack(result, candidates, target - candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
