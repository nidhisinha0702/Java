package TwoPointer;

import java.util.Arrays;

public class TripletsWithSmallerSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = {-2, 0, 1, 3};
		int sum = 2, n = 4;
		System.out.println("count triplets with smaller sum: "+countTriplets(n, sum, arr));

	}
	static long countTriplets(int n, int sum, long arr[]) {
        Arrays.sort(arr);
        long cnt = 0;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                long s = arr[left] + arr[right] + arr[i];
                if(s < sum){
                    cnt += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }return cnt;
    }
}
