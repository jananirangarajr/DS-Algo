package leet.Neetcode.dp.twoD;

public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("bl","ybl"));
    }
    public static int  longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1+dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
       /*
       didn't work test cases: text1= bl text 2= ybl
       int globalMax = 0;

        for (int i = 0; i < text2.length(); i++){

            for (int j = 0; j < text1.length(); j++){
                if (text1.charAt(j) == text2.charAt(i)){
                    int k = j+1, l = i+1;
                    int curLen = 0;
                    while ( k < text1.length() && l < text2.length()){
                        if (text1.charAt(k) == text2.charAt(l)){
                            curLen = l-i;
                            l++;
                        }
                        k++;
                    }
                    globalMax = Math.max(globalMax, curLen);
                }
            }
        }
        return globalMax ==0? 0 : globalMax+1;*/
    }
}
