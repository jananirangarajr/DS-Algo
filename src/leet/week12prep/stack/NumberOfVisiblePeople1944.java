package leet.week12prep.stack;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeople1944 {
    public static void main(String[] args) {
        int[] nums = new int[] {10,6,8,5,11,9};
        Arrays.stream(canSeePersonsCount(nums)).forEach(x -> System.out.println(x));
    }
    public static int[] canSeePersonsCount(int[] heights) {
        /*int[] result = new int[heights.length];
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < n-1; i++){
            max = heights[i+1];
            int count = 0;
            for (int  j = i+1; j < n; j++){
                max = Math.max(max,heights[j]);
                if (heights[i] <= heights[j]){
                    count++;
                    break;
                }
                else if (Math.min(heights[i],heights[j]) >= max)
                    count++;
            }
            result[i] = count;
        }

        return result;*/

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];
        for (int i = heights.length-1; i >= 0; i--) {

            while(!stack.empty() && stack.peek() < heights[i]) {
                stack.pop();
                result[i]++;
            }
            if (!stack.isEmpty())
                result[i]++;
            stack.push(heights[i]);
        }
        return result;
    }
}
