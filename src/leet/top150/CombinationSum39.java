package leet.top150;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5,6};
        List<List<Integer>> result = new ArrayList<>();
        int target = 8;
        combination(nums,target,new ArrayList<Integer>(),result,0);

        for (List<Integer> s : result)
            System.out.println(s);

    }

    public static void combination(int[] nums, int target, ArrayList<Integer> subArray, List<List<Integer>> result, int index) {
        if (target == 0)
            result.add(new ArrayList<>(subArray));
        else if (target < 0 || index == nums.length)
                return;
        else {
            subArray.add(nums[index]);
            target -= nums[index];
            combination(nums,target,subArray,result,index);
            target += subArray.remove(subArray.size() - 1);
            combination(nums,target,subArray,result,index+1);
            return;
        }
    }
}
