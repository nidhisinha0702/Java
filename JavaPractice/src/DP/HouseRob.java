package DP;
import java.util.Arrays;

public class HouseRob {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int[] row: dp)
            Arrays.fill(row , -1);
        return fun(nums, 0, 1, n, dp);
    }
    public int fun(int[] arr, int i, int free, int n, int[][] dp){
        if(i == n)
            return 0;
        if(dp[i][free] != -1)
            return dp[i][free];
        if(free == 0)
            return dp[i][0] = fun(arr, i+1, 1, n, dp);

        int a1 = arr[i] + fun(arr, i+1, 0, n, dp);
        int a2 = fun(arr, i+1, 1, n, dp);
        return dp[i][free] = Math.max(a1,a2);
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;//base case
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if(j == 0)
                    dp[i][j] = dp[i+1][1];
                else
                    dp[i][j] = Math.max(nums[i] + dp[i+1][0], dp[i+1][1]);
            }
        }

        return dp[0][1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        //int[][] dp = new int[n+1][2];
        int next[] = new int[2];
        next[0] = next[1] = 0;
        for(int i=n-1;i>=0;i--){
            int curr[] = new int[2];
            for(int j=0;j<=1;j++){
                if(j==0)
                    curr[j] = next[1];
                else
                    curr[j] = Math.max(nums[i] + next[0] , next[1]);
            }next = curr;
        }
        return next[1];
    }
}
