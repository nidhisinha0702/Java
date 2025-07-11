package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Spriral matrix is : "+spiralOrder(matrix));
	}
	//TC->O(n X n)
	 public static List<Integer> spiralOrder(int[][] matrix) {
		 int n = matrix.length, m = matrix[0].length;
	        int srow = 0, scol = 0, erow = n-1, ecol = m-1;
	        List<Integer> ans = new ArrayList<>();
	        //works for both odd and even
	        while(srow <= erow && scol <= ecol){
	            //top
	            for(int j=scol;j<=ecol;j++){
	                ans.add(matrix[srow][j]);
	            }
	            //right
	            for(int i=srow+1;i<=erow;i++){
	                ans.add(matrix[i][ecol]);
	            }
	            //bottom
	            for(int j=ecol-1;j>=scol;j--){
	            	//prevent duplicate elements
	                if(srow == erow){
	                    break;
	                }
	                ans.add(matrix[erow][j]);
	            }
	            //left
	            for(int i=erow-1;i>=srow+1;i--){
	            	//prevent duplicate elements
	                if(scol == ecol){
	                    break;
	                }
	                ans.add(matrix[i][scol]);
	            }
	            srow++;erow--;scol++;ecol--;
	        }
	        return ans;
	    }
}
