package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		//WAP to place nqueens on a n*n chess board
		int n = 4;
		NQueens obj = new NQueens();
		List<List<String>> answer = obj.solveNQueens(n);
		System.out.println(answer);

	}
	
	List<List<String>> solveNQueens(int n){
		char[][] board =  {{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'},{'.','.','.','.'}};
		List<List<String>> ans = new ArrayList<>();
		nQueens(board, 0, n, ans);
		return ans;
	}
	
	void nQueens(char[][] board, int row, int n, List<List<String>> ans) {
		//bc
		if(row == n) {
			ans.add(convertArrayToList(board));
			return;
		}
		
		for(int j = 0;j<n;j++) {
			if(isSafe(board, row, j, n)) {
				board[row][j] = 'Q';
				nQueens(board, row + 1, n, ans);
				//backtrack
				board[row][j] = '.';
			}
		}
	}
	
	private List<String> convertArrayToList(char[][] board){
		List<String> result = new ArrayList<>();
		for(char[] b:board) {
			for(char bd:b) {
				result.add(bd+"");
			}
		}return result;
	}
	
	private boolean isSafe(char[][] board, int row, int col, int n) {
		//Horizontal
		for(int j=0;j<n;j++) {
			if(board[row][j] == 'Q')
				return false;
		}
		
		//Vertical
		for(int i=0;i<n;i++) {
			if(board[i][col] == 'Q')
				return false;
		}
		
		//Left Upward Diagonal
		for(int i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j] == 'Q')
				return false;
		}
		
		//Right Upward Diagonal
		for(int i=row,j=col;i>=0 && j<n;i--,j++) {
			if(board[i][j] == 'Q')
				return false;
		}
		
		return true;
	}

}
