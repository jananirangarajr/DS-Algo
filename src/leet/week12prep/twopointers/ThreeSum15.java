package leet.week12prep.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums =  new int[]{-1,0,1,0,-1,1};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++){
            if (i > 0 && nums[i] == nums[i-1] && nums[i] != 0)
                continue;
            int left = i+1, right = nums.length-1;
            while(left != right) {
                int sum = nums[left]+nums[right]+nums[i];
                if (sum == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    result.add(list);
                    left++;
                    while (nums[left] == nums[left-1] && right!= left)
                        left++;
                }
                else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }
}
