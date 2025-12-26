package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));

	}
	
	public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();
        int ans = 0;
        //push all source into q
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Tuple(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        //bfs
        while(q.size() > 0){
            int i = q.peek().first;
            int j = q.peek().second;
            int time = q.peek().third;
            q.poll();

            ans = Math.max(ans, time);

            //top
            if(i-1 >= 0 && vis[i-1][j] == 0 && grid[i-1][j] == 1){
                q.offer(new Tuple(i-1, j, time + 1));
                vis[i-1][j] = 1;
            }
            //right
            if(j+1 < m && vis[i][j+1] == 0 && grid[i][j+1] == 1){
                q.offer(new Tuple(i, j+1, time + 1));
                vis[i][j+1] = 1;
            }
            //bottom
            if(i+1 < n && vis[i+1][j] == 0 && grid[i+1][j] == 1){
                q.offer(new Tuple(i+1, j, time + 1));
                vis[i+1][j] = 1;
            }
            //left
            if(j-1 >= 0 && vis[i][j-1] == 0 && grid[i][j-1] == 1){
                q.offer(new Tuple(i, j-1, time + 1));
                vis[i][j-1] = 1;
            }
        }

        //check for fresh oranges
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    return -1;
                }
            }
        }

        return ans;
    }

    static class Tuple{
        int first, second, third;

        Tuple(int f, int s, int t){
            first = f;
            second = s;
            third = t;
        }
    }

}
