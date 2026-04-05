package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 410;
        System.out.println("Sum of digits: "+sumOfDigits(n));
    }
    static int sumOfDigits(int n) {
        // code here
        int[] ans = new int[1];
        fun(n, ans);
        return ans[0];
    }

    static int fun(int n, int[] ans){
        if(n == 0)
            return 0;
        int r = n % 10;
        n = n / 10;
        ans[0] = ans[0]+r;
        return fun(n, ans);
    }
}
