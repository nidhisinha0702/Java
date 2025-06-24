package Arrays;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		maximumSubarray(arr);
		System.out.println("maximum sub-array sum is : "+maximumSubarraySum(arr));
		System.out.println("maximum sub-array sum is : "+kadanesAlgo(arr));
	}
	
	private static void maximumSubarray(int arr[]) {
		//n = 5, no of sub-array = n *(n+1)/2
		int n = arr.length;
		//find the start and end of the sub-arrays and print them
		for(int st=0;st<n;st++) {
			for(int end=st;end<n;end++) {
				//to print from st to end
				for(int i=st;i<=end;i++) {
					System.out.print(arr[i]);
				}System.out.print(" ");
			}System.out.println();
		}
	}
	//TC->O(n^2)
	private static int maximumSubarraySum(int arr[]) {
		//n = 5, sub-array = n *(n+1)/2
		int n = arr.length;
		int maxSum = 0;
		//find the start and end of the sub-arrays and print them
		for(int st=0;st<n;st++) {
			int curSum = 0;
			for(int end=st;end<n;end++) {
				//start is constant we can add end to the curr sum to find the total sum of that sub-array
				curSum += arr[end];
				maxSum = Math.max(maxSum, curSum);
			}
		}return maxSum;
	}
	
	//TC->O(n)
	private static int kadanesAlgo(int arr[]) {
		int n = arr.length;
		int currSum = 0, maxSum = Integer.MIN_VALUE;
		for(int num:arr) {
			currSum += num;
			maxSum = Math.max(maxSum, currSum);
			//we want to find the max sum at-least once, if we have all the -ve numbers in the array the ans will be a negative number
			//and if we write the below condition before calculating maxSum it will be 0
			if(currSum < 0) {
				currSum = 0;
			}
		}return maxSum;
	}
}
