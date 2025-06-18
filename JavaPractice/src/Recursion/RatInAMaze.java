package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

	public static void main(String[] args) {
		// WAP to find the path of rat to reach end
		int maze[][] = {
				{1 ,1, 1, 0, 1},
				{1, 0, 1, 1, 1},
				{0, 0, 1, 1, 1},
				{1, 0, 0, 1, 1},
				{1, 0, 0, 0, 1}};
		List<String> ans = new ArrayList<>();
		String path = "";
		getAns(maze, 0, 0, ans, path);
		System.out.println(ans);

	}
	//TC->O(4^n^2) SC->O(n*n) stack space of recursion
	private static void getAns(int maze[][], int r, int c, List<String> ans, String path) {
		//bc
		int n = maze.length;
		if(r < 0 || c < 0 || r >= n || c >= n || maze[r][c] == 0 || maze[r][c] == -1)
			return;
		if(r == n-1 && c == n-1) {
			ans.add(path);
			return;
		}
		
		//mark the box as visited 
		maze[r][c] = -1;
		
		getAns(maze, r+1, c, ans, path+"D");//down
		getAns(maze, r-1, c, ans, path+"U");//up
		getAns(maze, r, c-1, ans, path+"L");//left
		getAns(maze, r, c+1, ans, path+"R");//right
		
		//mark as unvisited - backtrack
		maze[r][c] = 1;
	}

}
