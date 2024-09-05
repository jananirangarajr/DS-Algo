package leet.Neetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public class CoinChange322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,3,4,5},7));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        /*
        //Works, but another efficient approch below
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++){
            dp[coins[i]] = 1;
        }
        return change(coins,amount,dp);*/

        // Dp top down memoization
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]); //dp[7] = 1+dp[7-4]
                }
            }
        }
        return dp[amount] > amount?-1:dp[amount];
    }

    private static  int change(int[] coins, int amount,int[] dp){
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 1;
        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
//        int res = Integer.MAX_VALUE;
        for (int i = coins.length-1; i >= 0; i--){
            int val = 0;
            val += change(coins,(amount-coins[i]),dp);
            if ( val != -1) {
                dp[amount] = Math.min(dp[amount], val+1);
                //break;
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}
