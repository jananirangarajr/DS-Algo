package leet.dp.stocks;

public class BTBASIII123 {
    public static void main(String[] args) {
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfitTabulation(nums));
        System.out.println(maxProfitTabulationConstant(nums));
    }
    public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        // for (int[] row: dp)
        //     Arrays.fill(row, Integer.MAX_VALUE);
        return maxProfit(prices, 0, 1,dp,1);
    }
    public static int maxProfit(int[] prices, int index,int buy,int[][][] dp,int k){
        if (index == prices.length || k < 0)
            return 0;
        if (dp[index][buy][k] != 0)
            return dp[index][buy][k];
        else{
            int profit = 0;
            if (buy == 1){
                profit = Math.max(maxProfit(prices,index+1,0,dp,k)-prices[index], maxProfit(prices,index+1,1,dp,k));
            }
            else {
                profit = Math.max(maxProfit(prices,index+1,1,dp,k-1) + prices[index],maxProfit(prices,index+1,0,dp,k));

            }
            return dp[index][buy][k] = profit;
        }
    }

    public static int maxProfitTabulation(int[] prices){
        int[][][] dp = new int[prices.length+1][2][3];
        for (int index = prices.length-1; index >=0; index--){
            for (int buy = 0; buy <= 1; buy++){
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (buy == 1){
                        profit = Math.max(dp[index+1][0][cap]-prices[index], dp[index+1][1][cap]);
                    }
                    else {
                        profit = Math.max(dp[index+1][1][cap-1] + prices[index],dp[index+1][0][cap]);

                    }
                    dp[index][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }

    public static int maxProfitTabulationConstant(int[] prices){
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];
        // int[][][] dp = new int[prices.length+1][2][3];
        for (int index = prices.length-1; index >=0; index--){
            for (int buy = 0; buy <= 1; buy++){
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (buy == 1){
                        cur[buy][cap] = Math.max(ahead[0][cap]-prices[index], ahead[1][cap]);
                    }
                    else {
                        cur[buy][cap] = Math.max(ahead[1][cap-1] + prices[index],ahead[0][cap]);

                    }
                    ahead[buy][cap] = cur[buy][cap];
                }
            }
        }
        return ahead[1][2];
    }
}
