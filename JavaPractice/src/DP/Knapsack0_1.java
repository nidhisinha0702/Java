package DP;
import java.util.Arrays;

public class Knapsack0_1 {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int[] r:dp)
            Arrays.fill(r, -1);
        return fun(W, val, wt, n, 0, dp);

    }

    public int fun(int cap, int[] val, int[] wt,int n, int i, int[][] dp){
        if(i == n)
            return 0;

        if(dp[i][cap] != -1)
            return dp[i][cap];

        if(wt[i] > cap)
            return dp[i][cap] = fun(cap, val, wt, n, i+1, dp);

        int pick = val[i] + fun(cap-wt[i], val, wt, n, i+1, dp);
        int notpick = fun(cap, val, wt, n, i+1, dp);

        return dp[i][cap] = Math.max(pick, notpick);
    }

    public int knapsack1(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];//dp array for storing val array and W capacity
        for(int j=0;j<=W;j++)
            dp[n][j] = 0;//base case for all W i==n is 0

        for(int i=n-1;i>=0;i--){//val
            for(int j=0;j<=W;j++){//cap(W)
                if(wt[i] > j)//current cap is greater than cap(W)
                    dp[i][j] = dp[i+1][j];//go to next
                else
                    dp[i][j] = Math.max(val[i] + dp[i+1][j - wt[i]], dp[i+1][j]);//pick and not pick choices
            }
        }

        return dp[0][W];

    }
}
