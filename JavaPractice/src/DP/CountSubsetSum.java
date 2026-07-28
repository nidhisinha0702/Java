package DP;

public class CountSubsetSum {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n+1][target+1];

        for(int j=0;j<=target;j++){
            dp[n][j] = 0;
        }
        dp[n][0] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=target;j++){
                if(arr[i] > j)
                    dp[i][j] = dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j-arr[i]] + dp[i+1][j];
            }
        }
        return dp[0][target];
    }

    static int fun(int[] arr, int i, int n, int target, int[][] dp){
        if(i == n){
            if(target == 0){
                dp[n][0] = 1;
                return 1;
            }else{
                dp[n][i] = 0;
                return 0;
            }
        }

        if(dp[i][target] != -1)
            return dp[i][target];

        if(arr[i] > target){
            return dp[i][target] = fun(arr, i+1, n, target, dp);
        }
        else{
            int c1 = fun(arr, i+1, n, target - arr[i], dp);
            int c2 = fun(arr, i+1, n, target, dp);
            dp[i][target] = c1 + c2;
            return c1 + c2;
        }
    }
}
