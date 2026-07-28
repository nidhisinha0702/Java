package Graph;
import java.util.*;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int diffs[][] = new int[n][m];
        for(int diff[]:diffs)
            Arrays.fill(diff, Integer.MAX_VALUE);

        diffs[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.first - b.first);

        pq.offer(new Tuple(0,0,0));

        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int d = t.first;
            int r = t.second;
            int c = t.third;

            if(d > diffs[r][c])
                continue;

            for(int i=0;i<4;i++){
                int nrow = r + dx[i];
                int ncol = c + dy[i];
                if(isValid(nrow, ncol, n, m)){
                    int absDiff = Math.abs(heights[r][c] - heights[nrow][ncol]);
                    int newWt = Math.max(d, absDiff);
                    if(newWt < diffs[nrow][ncol]){
                        diffs[nrow][ncol] = newWt;
                        pq.offer(new Tuple(newWt, nrow, ncol));
                    }
                }
            }
        }
        return diffs[n-1][m-1];
    }
    public boolean isValid(int r, int c, int n, int m){
        return (r < 0 || r >= n || c < 0 || c >= m) ? false : true;
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
