package leet.week12prep.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        Arrays.stream(result).forEach(x -> System.out.println(x));
    }
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n-1; i >=0; i--) {
            int sum = 0;
            if (stack.isEmpty()){
                stack.push(i);
                result[i] = 0;
            }
            else {
                if(temperatures[stack.peek()] > temperatures[i]){
                    stack.push(i);
                    result[i] = 1;
                }
                else {
                    while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
//                        count++;
                        stack.pop();
                    }
                    if (stack.isEmpty()){
                        result[i] = 0;
                    }
                    else
                        result[i] = stack.peek()-i;
                    stack.push(i);
                }

            }
        }
        return result;
    }
}
