package Recursion;

public class SudokuSolver {

	public static void main(String[] args) {
		//WAP to solveSudoku
		char[][] board =   {{'5','3','.','.','7','.','.','.','.'},
		                    {'6','.','.','1','9','5','.','.','.'},
		                    {'.','9','8','.','.','.','.','6','.'},
		                    {'8','.','.','.','6','.','.','.','3'},
		                    {'4','.','.','8','.','3','.','.','1'},
		                    {'7','.','.','.','2','.','.','.','6'},
		                    {'.','6','.','.','.','.','2','8','.'},
		                    {'.','.','.','4','1','9','.','.','5'},
		                    {'.','.','.','.','8','.','.','7','9'}};
		System.out.println("solve sudoku: "+solveSudoku(board, 0, 0));

	}
	//TC->O(9^empty cells)
	private static boolean solveSudoku(char[][] board, int row, int col) {
		//bc
		if(row == 9) {
			return true;
		}
		
		//row wise move to next col 
		int nextRow = row;
		int nextCol = col + 1;
		//reach last col change row and reset col
		if(nextCol == 9) {
			nextRow = row + 1;
			nextCol = 0;
		}
		
		//if only there is dot solve
		if(board[row][col] != '.') {
			return solveSudoku(board, nextRow, nextCol);
		}
		
		//try to put all possible digits
		for(char digit = '1';digit<='9';digit++) {
			if(isSafe(board, row, col, digit)) {
				board[row][col] = digit;
				if(solveSudoku(board, nextRow, nextCol))
					return true;
				//backtrack
				board[row][col] = '.';
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(char[][] board, int row, int col, int digit) {
		//Horizontal
		for(int j=0;j<9;j++) {
			if(board[row][j] == digit)
				return false;
		}
		//Vertical
		for(int i=0;i<9;i++) {
			if(board[i][col] == digit)
				return false;
		}
		//grid
		int sr = row/3 * 3;
		int sc = col/3 * 3;
		for(int i=sr;i<=sr+2;i++) {
			for(int j=sc;j<=sc+2;j++) {
				if(board[i][j] == digit)
					return false;
			}
		}
		return true;
	}

}
