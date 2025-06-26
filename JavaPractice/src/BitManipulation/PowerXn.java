package BitManipulation;

public class PowerXn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x = 2.0000; int n = 2;
		System.out.println("power of x is : "+myPow(x, n));

	}
	//TC->O(log n)
	 public static double myPow(double x, int n) {
	        //convert power into binary and find power
	        if(n == 0) return 1.0;
	        if(x == 0) return 0.0;
	        if(x == 1) return 1.0;
	        if(x == -1 && n%2 == 0) return 1.0;
	        if(x == -1 && n%2 == 1) return -1.0;

	        long binForm = n;
	        //for -ve number
	        if(n < 0){
	            x = 1/x;
	            binForm = -binForm;
	        }
	        //store ans
	        double ans = 1;
	        //apply loop on binary form of power
	        while(binForm > 0){
	        	//only consider base 1 as 0 will give 0
	        	//find binary by % 2
	            if(binForm % 2 == 1){
	                ans *= x;
	            }
	            //otherwise multiply x * x
	            x *= x;//x*x
	            binForm /= 2;//binForm/2
	        }
	        return ans;
	    }
}
