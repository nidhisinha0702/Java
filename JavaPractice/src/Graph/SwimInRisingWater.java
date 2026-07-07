package Graph;
import java.util.*;
public class SwimInRisingWater {
    public static void main(String[] args) {
        int grid[][] =  {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println("Minimum time to swim from 0,0 to n-1,n-1 is "+swimInWater(grid));

    }
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Tuple(grid[0][0], 0, 0));
        int vis[][] = new int[n][n];
        vis[0][0] = 1;
        int time = 0;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Tuple tup = pq.poll();
            int curVal = tup.first;
            int curRow = tup.second;
            int curCol = tup.third;
            //the max time till now will be the ans
            time = Math.max(time, curVal);

            if (curRow == n - 1 && curCol == n - 1) break;

            for (int ind = 0; ind < 4; ind++) {
                int newr = curRow + dr[ind];
                int newc = curCol + dc[ind];
                if (isValid(newr, newc, n) && vis[newr][newc] == 0) {
                    vis[newr][newc] = 1;
                    pq.add(new Tuple(grid[newr][newc], newr, newc));
                }
            }

        }
        return time;
    }
    public static boolean isValid(int row, int col, int n){
        return row >= 0 && row < n && col >= 0 && col < n;
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
