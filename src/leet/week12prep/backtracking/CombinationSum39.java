package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
//        combinationSum(result,candidates,target,new ArrayList<>(),0, 0);
        combinationSum(result,candidates,target,new ArrayList<>(), 0);
        return result;
    }

    private static void combinationSum(List<List<Integer>> result, int[] candidates, int target, ArrayList list, int sum,int index) {
        if (sum == target) {
            result.add((List<Integer>) list.clone());
            return;
        }
        if (index == candidates.length || sum > target)
            return;
        else{
//            for (int i = index; i < candidates.length; i++){
                list.add(candidates[index]);
                sum += candidates[index];
                //System.out.println(list+" "+sum);
                combinationSum(result,candidates,target,list,sum,index);
                sum -= (int)list.remove(list.size()-1);
                //System.out.println("remove "+list+" "+sum);
                combinationSum(result,candidates,target,list,sum,index+1);
                return;
//            }
        }
    }

    private static void combinationSum(List<List<Integer>> result, int[] candidates, int target, ArrayList list,int index){
        if (target < 0)
            return;
        if (target == 0){
            result.add((List<Integer>) list.clone());
            return;
        }
        else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSum(result,candidates,target-candidates[i],list,index);
                list.remove(list.size()-1);
            }
        }
    }
}
