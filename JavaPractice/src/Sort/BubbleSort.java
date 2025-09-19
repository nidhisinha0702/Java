package Sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,1,5,2,3};
		int n = arr.length;
		bubble(arr,n);
		System.out.println(Arrays.toString(arr));
	}
	//TC->O(n^2)
	private static void bubble(int arr[], int n) {
		//it runs for n-1 iteration and larger values are swapped to last
		for(int i=n-1;i>=0;i--) {
			//optimization
			int didSwap = 0;
			for(int j=0;j<=i-1;j++) {
				//compare each element with next
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					didSwap = 1;
				}
			}if(didSwap == 0) {//already sorted
				break;
			}
		}
	}

}
