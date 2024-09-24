package leet.dp.stocks;

public class BTBASI121 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;

         int soFarMin = prices[0];
         int profit = 0;

         for (int i = 1; i < prices.length; i++){
             int cost = prices[i] - soFarMin;
             profit = Math.max(profit,cost);
             soFarMin = Math.min(soFarMin,prices[i]);
         }
         return profit;
         /*
         This works but inorder to make the time complexity o(n). store the minimum in a variable.
          For every value, calculate profit with it's sofar minimum
          */
         /* int maxProfit = 0;
         for (int i = 0; i < prices.length; i++) {
             for (int j = i+1; j < prices.length; j++){
                 if (prices[i] > prices[j])
                     break;
                 maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
             }
         }
         return maxProfit;*/
    }
}
