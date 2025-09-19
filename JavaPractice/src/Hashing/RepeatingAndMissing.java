package Hashing;

import java.util.HashSet;
import java.util.Set;

public class RepeatingAndMissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
		System.out.println("Repatig and missing values are : "+findMissingAndRepeatedValues(grid));

	}
	public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> s = new HashSet<>();
        int a = -1, b = -1;
        //n*(n+1)/2
        int expSum = n*n * (n*n + 1)/2;
        int actualSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                actualSum += grid[i][j];
                if(s.contains(grid[i][j])){
                    a = grid[i][j];
                }
                s.add(grid[i][j]);
            }
        }

        b = expSum + a - actualSum;
        return new int[]{a,b};
    }
}
