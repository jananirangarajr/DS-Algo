package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;
public class Combinations77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n,k,result, new ArrayList<>(),1);
        return result;
    }

    private static void combine(int n, int k, List<List<Integer>> result, ArrayList<Integer> list,int index) {
        if (list.size() == k)
        {
            result.add((List<Integer>) list.clone());
            return;
        }
        else {
            for (int i = index; i <= n; i++){
                list.add(i);
                combine(n,k,result,list,i+1);
                list.remove(list.size()-1);
            }
        }
        return;
    }
}
