package leet.practice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumII167 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] result = new int[2];
        while (left != right){
            if (numbers[left]+numbers[right] == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            else if (numbers[left]+numbers[right] > target)
                right--;
            else
                left++;
        }
        return result;
    }
}
