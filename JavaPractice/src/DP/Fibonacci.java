package DP;

public class Fibonacci {
    public int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public int fib1(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        if(n <= 1) return n;
        int prev_prev = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int ans = prev + prev_prev;
            prev_prev = prev;
            prev = ans;
        }
        return prev;
    }
}
