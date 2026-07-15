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
}
