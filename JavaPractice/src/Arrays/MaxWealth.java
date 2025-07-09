package Arrays;

public class MaxWealth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int accounts[][] = {{1,2,3},{5,2,7},{8,9}};
		System.out.println("The maximum wealth is : "+maximumWealth(accounts));

	}
	private static int maximumWealth(int[][] accounts) {
		int ans = Integer.MIN_VALUE;
		for(int[] num: accounts) {
			int sum = 0;
			for(int acc:num) {
				sum += acc;
			}
			if(sum > ans) {
				ans = sum;			
				}
		}return ans;
			
	}
}
