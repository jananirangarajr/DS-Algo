package leet.week12prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement503 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int[] result = nextGreaterElements(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result =  new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else {
                while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                    result[stack.peek()] = nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
         while(!stack.empty()){
             if (stack.firstElement() == stack.peek())
             {
                 result[stack.peek()] = -1;
                 stack.pop();
                 break;
             }
             if (nums[stack.peek()] < nums[stack.firstElement()])
                result[stack.peek()] = nums[stack.firstElement()];
             else
                 result[stack.peek()] = -1;
             stack.pop();
         }
        return result;
    }
}
