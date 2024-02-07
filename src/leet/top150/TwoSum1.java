package leet.top150;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2};
        int target = 3;
        TwoSumSolution solution = new TwoSumSolution();
        System.out.println(Arrays.stream(solution.twoSum(nums,target)).toString());
    }
}
class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]),i};
            }
            else {
                map.put(key,i);
            }
        }
        return new int[2];

    }
}
