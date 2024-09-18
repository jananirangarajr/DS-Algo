package leet.dp.stocks;

import java.util.Arrays;

public class BTBASII122 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
//        System.out.println(maxProfit(nums));
        System.out.println(maxProfitDP(nums));
    }
    public static int maxProfit(int[] prices) {
        //greedy - approach works
        if (prices.length == 1)
            return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i-1] < prices[i])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
    public static int maxProfitDP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        return maxProfitDP(prices, 0, 1,dp);
    }

    public static int maxProfitDP(int[] prices, int index, int buy,int[][] dp){
        if (index == prices.length)
            return 0;
        if (dp[index][buy] != Integer.MAX_VALUE)
            return dp[index][buy];
        else{
            int profit = 0;
            if (buy == 1){
                profit = Math.max(maxProfitDP(prices,index+1,0,dp) -prices[index], maxProfitDP(prices,index+1,1,dp));
            }
            else {
                profit = Math.max(maxProfitDP(prices,index+1,1,dp) + prices[index],maxProfitDP(prices,index+1,0,dp));
            }
            return dp[index][buy] = profit;
        }
    }
}
