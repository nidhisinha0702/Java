package DP;
import java.util.Arrays;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] r: dp)
            Arrays.fill(r, -1);
        return fun(text1, text2, n, m , 0, 0, dp);
    }

    public int fun(String s1, String s2, int n, int m, int i, int j, int[][] dp){
        if(i == n || j == m){
            dp[n][j] = dp[i][m] = 0;
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + fun(s1, s2, n, m, i+1, j+1, dp);

        int c1 = fun(s1, s2, n, m, i+1, j, dp);
        int c2 = fun(s1, s2, n, m, i, j+1, dp);
        return dp[i][j] = Math.max(c1, c2);

    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++)
            dp[i][m] = 0;
        for(int j=0;j<=m;j++)
            dp[n][j] = 0;

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}
