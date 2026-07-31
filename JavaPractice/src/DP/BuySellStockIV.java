package DP;
import java.util.Arrays;

public class BuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int[] r:dp)
            Arrays.fill(r, -1);
        return fun(prices, n, 0, 2*k, dp);

    }

    public int fun(int[] arr, int n, int i, int k, int[][] dp){
        if(i == n){
            dp[n][k] = 0;
            return 0;
        }
        if(k == 0){
            dp[i][0] = 0;
            return 0;
        }
        if(dp[i][k] != -1)
            return dp[i][k];
        if(k%2 == 0){
            int c1 = fun(arr, n, i+1, k-1, dp) - arr[i];
            int c2 = fun(arr, n, i+1, k, dp);
            return dp[i][k] = Math.max(c1, c2);
        }else{
            int c3 = fun(arr, n, i+1, k-1, dp) + arr[i];
            int c4 = fun(arr, n, i+1, k, dp);
            return dp[i][k] = Math.max(c3,c4);
        }
    }

    public int maxProfit1(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        for(int j=0;j<2*k+1;j++)
            dp[n][j] = 0;
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;

        for(int i=n-1;i>=0;i--){
            for(int j=1;j<2*k+1;j++){
                if(j%2 == 0){
                    dp[i][j] = Math.max(dp[i+1][j-1] - prices[i], dp[i+1][j]);
                }else{
                    dp[i][j] = Math.max(prices[i] + dp[i+1][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][2*k];

    }
}
