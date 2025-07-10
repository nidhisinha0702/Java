package Search;

public class searchIn2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{1,2,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println("element is found : "+searchMat(mat, 34));
		
		int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println("element is found in matrix : "+searchInMatrixII(matrix, 5));
	}
	//TC-> O(log n) + O(log m) ~= O(log (m x n))
	static boolean searchMat(int [][]mat, int target) {
		//BS on total rows
		int n = mat.length, m = mat[0].length;
		int startRow = 0, endRow = n - 1;
		while(startRow<=endRow) {
			int midRow = startRow + (endRow - startRow)/2;
			
			if(target >= mat[midRow][0] && target <= mat[midRow][m-1]) {
				return searchInRow(mat, target, midRow);
			}else if(target >= mat[midRow][m-1]) {
				//down
				startRow = midRow + 1;
			}else {
				//up
				endRow = midRow - 1;
			}
		}return false;
	}
	
	static boolean searchInRow(int[][] mat, int tar, int midRow) {
		int n = mat[0].length;
		int st = 0, end = n-1;
		while(st <= end) {
			int mid = st + (end - st)/2;
			
			if(mat[midRow][mid] == tar)
				return true;
			else if(tar > mat[midRow][mid])
				st = mid + 1;
			else 
				end = mid - 1;
		}return false;
	}
	
	//TC-> O(n + m)
	static boolean searchInMatrixII(int mat[][], int target) {
		int n = mat.length, m = mat[0].length;
		//we are taking 1st row last element as mid or we can take last row 1st element as mid
		int r=0, c = m-1;
		while(r < m && c>= 0) {
			if(target == mat[r][c])
				return true;
			else if(target < mat[r][c])
				c--;
			else
				r++;
		}return false;
	}

}
