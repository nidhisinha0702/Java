package binarysearch;

import java.util.Arrays;

public class CapacityToShip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		int days = 5;
		
		System.out.println("Minimum capacity required to ship all the boxes withing d days is : "+minCapacity(weights, days));

	}
	
	static int minCapacity(int[] weights, int days) {
		
		//range [Max of arr, Sum of All Ele in arr]
		int low = Arrays.stream(weights).max().getAsInt();
		int high = 0;
		for(int i:weights)
			high+= i;
		
		while(low<=high) {
			int mid = low + (high - low)/2;
			int reqDays = canShip(weights, mid);
			
			if(reqDays <= days) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
			
		}return low;
		
	}
	
	static int canShip(int[] weights, int cap) {
		int days = 1, load = 0;
		for(int i=0;i<weights.length;i++) {
			if(weights[i]+load > cap) {
				days = days + 1;
				load = weights[i];
			}else {
				load = load + weights[i];
			}
		}
		return days;
	}

}
