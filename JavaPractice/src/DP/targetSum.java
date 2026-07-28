package DP;

public class targetSum {
    public int totalWays(int[] arr, int target) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int a:arr){
            sum += a;
        }

        int targetSum = (sum - target)/2;
        if(sum < target || (sum - target) %2 == 1) return 0;

        int[][] dp = new int[n+1][targetSum + 1];

        for(int j=0;j<=targetSum;j++){
            dp[n][j] = 0;
        }
        dp[n][0] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=targetSum;j++){
                if(arr[i] > j)
                    dp[i][j] = dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j-arr[i]] + dp[i+1][j];
            }
        }

        return dp[0][targetSum];
    }
}
