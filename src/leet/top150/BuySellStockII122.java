package leet.top150;

public class BuySellStockII122 {
    public static void main(String[] args) {
        int[] profit = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(profit));
    }
    public static int maxProfit(int[] prices) {
//        return maxProfit(prices,0,0,0,0);

        int profit = 0;

        for (int i = 1; i < prices.length-1; i++) {
            if (prices[i-1] < prices[i])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    private static int maxProfit(int[] prices, int index, int stockValue, int profit, int maxProfit) {
        //logic by bracktracking : sell the stock or hold the stock.
        boolean isChanged = false;
        for (int i = index; i < prices.length; i++) {
            if (stockValue == 0) {
                stockValue = prices[i];
                isChanged = true;
            }
            if (stockValue < prices[i]) {
                profit += prices[i] - stockValue;
                stockValue = 0;
                if (profit > maxProfit)
                    maxProfit = profit;
            }
            maxProfit = maxProfit(prices, index+1, stockValue, profit, maxProfit);
            if (isChanged){
                stockValue -= prices[i];
                profit -= prices[i];
            }
            maxProfit = maxProfit(prices, index+1, stockValue, profit,maxProfit);

        }

        return maxProfit;
        // didn't work for inputs with the increasing order {1,2,3,4,5}
    }
}
