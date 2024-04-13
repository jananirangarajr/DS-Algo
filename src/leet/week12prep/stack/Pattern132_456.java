package leet.week12prep.stack;

import java.util.Stack;

public class Pattern132_456 {
    public static void main(String[] args) {
        int[] nums = new int[] {8,10,5,7,6};
        System.out.println(find132pattern(nums));
    }
    public static boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int minValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (stack.peek() <= nums[i]){
                while(!stack.empty() && stack.peek() >= nums[i])
                {
                    stack.pop();
                }

            }
            stack.push(nums[i]);
            minValue = Math.min(minValue,nums[i]);
        }
        return false;
    }
}
