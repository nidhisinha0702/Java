package Search;

public class LS2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix [][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		System.out.println(linearSearch(matrix, 4, 3, 8));
		System.out.println(maxRowSum(matrix, 4, 3));
		System.out.println(maxColSum(matrix, 4, 3));
		int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(maxDiaSum(mat, 4));

	}

	private static boolean linearSearch(int mat[][], int rows, int cols, int key) {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(mat[i][j] == key) {
					return true;
				}
			}
		}return false;
	}
	
	private static int maxRowSum(int mat[][], int rows, int cols) {
		int maxRowSum = 0;
		for(int i=0;i<rows;i++) {
			int currSum = 0;
			for(int j=0;j<cols;j++) {
				currSum += mat[i][j];
				maxRowSum = Math.max(maxRowSum, currSum);
			}
		}return maxRowSum;
	}
	
	private static int maxColSum(int mat[][], int rows, int cols) {
		int maxColSum = 0;
		for(int i=0;i<cols;i++) {
			int currSum = 0;
			for(int j=0;j<rows;j++) {
				currSum += mat[j][i];
				maxColSum = Math.max(maxColSum, currSum);
			}
		}return maxColSum;
	}
	
	private static int maxDiaSum(int mat[][], int n) {
		int sum = 0;
		for(int i=0;i<n;i++) {
				//primary diagonal top-left to bottom right
					sum += mat[i][i];
				//secondary diagonal top-right to bottom left
				if(i != n-i-1)//avoid common value for odd n
					sum += mat[i][n-i-1];
			}
		return sum;
	}
}
