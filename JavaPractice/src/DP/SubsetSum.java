package DP;
import java.util.Arrays;

public class SubsetSum {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int[] rows : dp)
            Arrays.fill(rows, -1);
        return fun(arr, 0, n, sum, dp);


    }
    static boolean fun(int[] arr, int i, int n, int sum, int[][] dp){
        //base case
        if(i == n){
            if(sum == 0){
                dp[n][0] = 1;
                return true;
            }else{
                dp[n][sum] = 0;
                return false;
            }
        }

        if(dp[i][sum] != -1)
            return dp[i][sum] == 1 ? true : false;

        boolean c1 = false;
        boolean c2 = false;

        if(arr[i] > sum){
            dp[i][sum] = fun(arr, i+1, n, sum, dp) == true ? 1 : 0;
            return fun(arr, i+1, n, sum, dp);
        }
        else{
            c1 = fun(arr, i+1, n, sum - arr[i], dp);
            c2 = fun(arr, i+1, n, sum, dp);
            dp[i][sum] = (c1 || c2) == true ? 1:0;
            return c1 || c2;
        }

    }

    static boolean isSubsetSum1(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int j=0;j<=sum;j++){
            dp[n][j] = false;
        }
        dp[n][0] = true;

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=sum;j++){
                if(arr[i] > j)
                    dp[i][j] = dp[i+1][j];
                else
                    dp[i][j] = dp[i+1][j - arr[i]] || dp[i+1][j];
            }
        }
        return dp[0][sum];
    }
}
