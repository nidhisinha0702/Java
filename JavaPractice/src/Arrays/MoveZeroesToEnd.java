package Arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,0,4,3,0,5,0};
//		int count = 0;
//		
//		//move all the non-zero to start
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i] != 0) {
//				arr[count++] = arr[i];
//			}
//		}
//		
//		//make all the elements to zero to the end
//		for(int j = count;j<arr.length;j++) {
//			arr[count++] = 0;
//		}
//		
		System.out.println(Arrays.toString(arr));
		pushZeroes(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	static void pushZeroes(int[] arr) {
		int count = 0;
		
		for(int i=0;i<arr.length;i++) {
			//swap non-zero elements
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				
				count++;
			}
		}
	}

}
