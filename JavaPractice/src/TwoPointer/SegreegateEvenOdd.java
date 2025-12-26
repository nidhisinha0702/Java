package TwoPointer;

import java.util.Arrays;

public class SegreegateEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6};
        segregate(arr);
        System.out.println(Arrays.toString(arr));
	}

	static void segregate(int[] arr) {
		int lo = 0, hi = arr.length - 1;
		
		while(lo < hi) {
			while(arr[lo] % 2 == 0 && lo < hi)
				lo++;
			while(arr[hi] % 2 != 0 && lo < hi)
				hi--;
			//swap
			if(lo < hi) {
				int temp = arr[lo];
				arr[lo] = arr[hi];
				arr[hi] = temp;
				lo++;
				hi--;
			}
		}
	}
}
