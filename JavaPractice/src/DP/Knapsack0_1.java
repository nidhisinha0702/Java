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
}
