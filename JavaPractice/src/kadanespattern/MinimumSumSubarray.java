package kadanespattern;

public class MinimumSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,-4, 2,-3,-1, 7,-5};
		int n = arr.length;
		System.out.println("The smallest sum subarray : "+smallestSumSubarray(arr, n));

	}
	static int smallestSumSubarray(int a[], int size) {
        // your code here
        int bestEnding = a[0];
        int ans = a[0];
        
        for(int i=1;i<size;i++){
            int v1 = a[i];
            int v2 = bestEnding + a[i];
            bestEnding = Math.min(v1, v2);
            ans = Math.min(ans, bestEnding);
        }return ans;
    }

}
