package Arrays;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1, 2, 3, 4},
	            {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15, 16}};
		
		 rotate90(mat);

	        // Print the rotated matrix
	        for (int[] row : mat) {
	            for (int x : row) {
	                System.out.print(x + " ");
	            }
	            System.out.println();
	        }

	}
	//O(n^2)
	 public static void rotate(int[][] matrix) {
	        int n = matrix.length;
	        int ans[][] = new int[n][n];

	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                ans[j][n-i-1] = matrix[i][j];
	            }
	        }

	        for(int i=0;i<n;i++){
	            System.arraycopy(ans[i], 0, matrix[i], 0, n);
	        }
	    }
	 
	 //O(n/2*n/2)
	 public static void rotate90(int[][] matrix) {
	        int n = matrix.length;
	        //transpose the matrix(row become column and column becomes row)
	        for(int i=0;i<n-1;i++){
	            for(int j=i+1;j<n;j++){
	            	//swap
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	        //reverse the row
	        for(int i=0;i<n;i++){
	            reverse(matrix[i]);
	        }
	    }
	 	//O(n*n/2)
	    static void reverse(int[] arr){
	        int n = arr.length;
	        int p1 = 0, p2 = n-1;
	        while(p1<p2){
	        	//swap
	            int t = arr[p1];
	            arr[p1] = arr[p2];
	            arr[p2] = t;
	            p1++;
	            p2--;
	        }
	    }

}
