package leet.Neetcode.dp.twoD;

import java.util.Arrays;

public class UniquePaths62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n== 1)
            return 1;

        int[] row = new int[n];
        Arrays.fill(row,1);
        for (int i = m-2; i >=0; i--){
            int[] newRow = new int[n];
             newRow[n-1] = 1;
            //Arrays.fill(newRow,1);
            for (int j = n-2; j >=0; j--){
                newRow[j] = newRow[j+1] + row[j];
            }
            row = newRow;
        }
        return row[0];

        /*
        This works
        int[][] dp = new int[m][n];
         dp[m-1][n-1] = 0;
         dp[m-2][n-1] = 1;
         dp[m-1][n-2] = 1;

         for (int i = m-1; i >=0; i--){
             for (int j = n-1; j >=0; j--){
                 if ((i == m-1 && j == n-1) || (i == m-2 && j == n-1) || (i == m-1 && j == n-2))
                     continue;
                 else {
                     int right = j+1 >= n ?0 : dp[i][j+1];
                     int down = i+1 >= m ? 0 : dp[i+1][j];
                     dp[i][j] = right+down;
                 }
             }
         }
         return dp[0][0];*/
    }
}
