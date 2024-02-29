package leet.top150;

public class BuySellStockII122 {
    public static void main(String[] args) {
        int[] profit = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(profit));
    }
    public static int maxProfit(int[] prices) {

        // consider
        int profit = 0;

        for (int i = 1; i < prices.length-1; i++) {
            if (prices[i-1] < prices[i])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }


}
