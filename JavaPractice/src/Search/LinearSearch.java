package Search;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {23,45,1,2,8,19,-3,16,-11,28};
		int target = 19;
		int ans = linearSearch(nums, target);
		System.out.println("Target is found at index : "+ans);
	}
	
	private static int linearSearch(int[] arr, int target) {
		if(arr.length == 0) {
			return -1;
		}
		
		//run a for loop
		for(int i=0;i<arr.length;i++) {
			int element = arr[i];
			if(element == target) {
				return i;
			}
		}
		return -1;
	}

}
