package Graph;

public class NoOfIsland {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    dfs(i ,j ,grid , vis, n, m);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, char grid[][], int vis[][], int n, int m){
        vis[row][col] = 1;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if(isValid(nrow,ncol,n,m) && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                dfs(nrow, ncol, grid, vis, n, m);
            }
        }return;

    }

    public boolean isValid(int r, int c, int n, int m){
        return (r < 0 || r >=n || c < 0 || c >= m) ? false : true;
    }
}
