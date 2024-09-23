package leet.dp.stocks;

import java.util.Arrays;

public class BTBASwithTransactionFee {
    public static void main(String[] args) {
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(nums,2));
    }
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        return maxProfit(prices, 0, 1,dp,fee);
    }
    public static int maxProfit(int[] prices, int index,int buy,int[][] dp,int fee){
        if (index == prices.length)
            return 0;
        if (dp[index][buy] != Integer.MAX_VALUE)
            return dp[index][buy];
        else{
            int profit = 0;
            if (buy == 1){
                profit = Math.max(maxProfit(prices,index+1,0,dp,fee)-prices[index], maxProfit(prices,index+1,1,dp,fee));
            }
            else {
                profit = Math.max(maxProfit(prices,index+1,1,dp,fee) + prices[index]-fee,maxProfit(prices,index+1,0,dp,fee));

            }
            return dp[index][buy] = profit;
        }
    }
}
