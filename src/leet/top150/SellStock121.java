package leet.top150;

public class SellStock121 {
    public static void main(String[] args) {
        int[] prices = new int[] {2,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        else {
            /*int maxprofit = 0;
            for (int i = 0; i < prices.length-1; i++) {
                for (int j = i+1; j < prices.length; j++) {
                    if (prices[i] < prices[j] && prices[j]- prices[i] > maxprofit) {
                        maxprofit = prices[j] - prices[i];
                    }
                }
            }
            return maxprofit;*/
            int n = prices.length;
            /*if (prices.length == 1)
                return 0;
            else {
                int mid = n/2-1;
                int i = 0 , j = mid;
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                while(i < mid+1 || j < n) {
                    if ( i <mid+1 && min > prices[i])
                        min = prices[i];
                    if (j < n && max < prices[j])
                        max = prices[j];
                    i++;
                    j++;
                }
                if (min < max)
                    return max - min;
                else
                    return 0;
            } Doesn't work for cases like [1,2,3] because the minimum element can be mid+1*/
            /*int leftPtr =0;
            int rightPtr=1;
            int maxProfit = 0;
            while(rightPtr < n){
                if (prices[leftPtr] < prices[rightPtr] && maxProfit < prices[rightPtr] - prices[leftPtr]) {
                    maxProfit = prices[rightPtr] - prices[leftPtr];
                }
                else if (prices[leftPtr] > prices[rightPtr])
                    leftPtr = rightPtr;
                rightPtr++;
            }*/
            //a small improvement decreases the runtime
            int leftPtr = 0;

            int maxProfit = 0;
            for(int rightPtr = 1; rightPtr < n; rightPtr++){
                if (prices[leftPtr] < prices[rightPtr]) {
                    maxProfit = Math.max(maxProfit,prices[rightPtr] - prices[leftPtr]);
                }
                else
                    leftPtr = rightPtr;
            }
            return maxProfit;

        }
    }
}
