package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;
public class CombinationSumIII216 {
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        System.out.println(combinationSum3(k,n));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<Integer>(),1,k, n,0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> list, int index, int k, int n, int sum) {
        if (list.size() > k || sum > n)
            return;
        else if (sum == n && list.size() == k)
        {
            result.add(new ArrayList<>(list));
            return;
        }
        else {
            for(int i = index; i <= 9; i++) {
                list.add(i);
                sum+= i;
                backtrack(result,list,i+1, k, n , sum);
                sum -= i;
                list.remove(list.size()-1);
            }
        }
    }
}
