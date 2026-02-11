package kadanespattern;

public class MaxSubarraySumWithOneDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,-2,0,3};
		System.out.println("Maximum subarray sum with one delete : "+maximumSum(arr));

	}
	public static int maximumSum(int[] arr) {
        int bestNoDelete = arr[0];
        int bestOneDelete = 0;
        int res = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            int oldNoDelete = bestNoDelete;
            int oldOneDelete = bestOneDelete;

            bestNoDelete = Math.max(oldNoDelete + arr[i], arr[i]);
            //oldOneDelete + a[i] , oldNoDelete (as a[i] is the one delete)
            bestOneDelete = Math.max(oldOneDelete + arr[i], oldNoDelete);

            res = Math.max(res, Math.max(bestNoDelete, bestOneDelete));
        }return res;
	}
}
