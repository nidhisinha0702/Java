package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  fruits[] = {1,2,1};
		System.out.println("Maximum length of atmost 2 distinct fruit in a basket is : "+totalFruit(fruits));
	}
	 public static int totalFruit(int[] fruits) {
	        int n = fruits.length;
	        Map<Integer,Integer> mpp = new HashMap<>();
	        int low = 0, high = 0, res = -1;

	        while(high < n){
	            mpp.put(fruits[high], mpp.getOrDefault(fruits[high],0)+1);
	            
	            while(mpp.size() > 2){
	                int rem = fruits[low];
	                mpp.put(rem, mpp.get(rem) - 1);
	                if(mpp.get(rem) == 0)
	                    mpp.remove(rem);
	                low++;
	            }
	            res = Math.max(res, high-low+1);
	            high++;
	        }return res;
	    }
}
