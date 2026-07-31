package DP;
import java.util.Arrays;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] r:dp)
            Arrays.fill(r, -1);
        return fun(m, n, 0, 0, dp);
    }
    public int fun(int m, int n, int i, int j, int[][] dp){
        if(i == m-1 && j == n-1){
            dp[m-1][j] = dp[i][n-1] = 1;
            return 1;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        if(i < 0 || i >= m || j < 0 || j >= n){
            dp[m][j] = dp[i][n] = 0;
            return 0;
        }

        return dp[i][j] = fun(m, n, i+1, j, dp) + fun(m, n, i, j+1, dp);
    }

    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            dp[i][n-1] = 1;
        for(int j=0;j<=n;j++)
            dp[m-1][j] = 1;
        for(int i=0;i<=m;i++)
            dp[i][n] = 0;
        for(int j=0;j<=n;j++)
            dp[m][j] = 0;

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
