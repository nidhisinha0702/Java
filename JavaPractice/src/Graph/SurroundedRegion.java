package Graph;

public class SurroundedRegion {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        //find all edges 'O' and make them #
        for(int i=0;i<n;i++){ //1st column
            if(board[i][0] == 'O'){
                dfs(board, n, m, i, 0);
            }
        }
        for(int i=0;i<n;i++){ //last column
            if(board[i][m-1] == 'O'){
                dfs(board, n, m, i, m-1);
            }
        }
        for(int j=0;j<m;j++){ //1st row
            if(board[0][j] == 'O'){
                dfs(board, n, m, 0, j);
            }
        }
        for(int j=0;j<m;j++){ //last row
            if(board[n-1][j] == 'O'){
                dfs(board, n, m, n-1, j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int n, int m, int i, int j){

        board[i][j] = '#';
        int[] row = {0,-1,1,0};
        int[] col = {1,0,0,-1};
        for(int k=0;k<4;k++){
            int nrow = i + row[k];
            int ncol = j + col[k];
            if(isValid(n, m, nrow, ncol) && board[nrow][ncol] == 'O'){
                dfs(board,n, m, nrow, ncol);
            }
        }return;

    }

    public boolean isValid(int n, int m, int i, int j){
        return i < 0 || i >= n || j < 0 || j >= m ? false : true;
    }
}
