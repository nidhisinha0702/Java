package DP;
import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+2];
        for(int[] rows : dp)
            Arrays.fill(rows, -1);
        return fun(nums, n, 0, -1, dp);

    }
    public int fun(int[] arr, int n, int i, int prev, int[][] dp){
        if(i == n){
            return 0;
        }

        if(dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        if(prev == -1 || arr[i] > arr[prev]){
            int c1 = 1 + fun(arr, n, i+1, i, dp);
            int c2 = fun(arr, n, i+1, prev, dp);
            return dp[i][prev + 1] = Math.max(c1,c2);
        }
        return dp[i][prev + 1] = fun(arr, n, i+1, prev, dp);
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    res[i] = Math.max(res[i],res[j] + 1);
                }
            }
        }
        int len = 1;
        for(int i=0;i<n;i++){
            if(len < res[i]){
                len = res[i];
            }
        }return len;
    }
}
