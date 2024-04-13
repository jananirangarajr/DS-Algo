package leet.week12prep.greedy;

import java.util.Stack;

public class BestTimeToBuySellII122 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int profit = 0;

        for (int x : prices){
            while(!stack.isEmpty() && stack.peek() > x){
//                stack.pop();
                stack.clear();
            }
            if (!stack.isEmpty()){
                profit += x-stack.peek();
            }
            stack.push(x);
        }
        return profit;
    }
}
