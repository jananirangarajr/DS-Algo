package leet.week12prep.greedy;

import java.util.Stack;

public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {
        int[] nums = new int[]{20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int x : nums) {
            if (stack.size() >= 3)
                return true;
            while(!stack.isEmpty() && stack.peek() > x){
                stack.pop();
            }
            stack.push(x);
        }
        return stack.size() >= 3;
    }
}
