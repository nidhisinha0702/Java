package Search;

public class KthSmallest {
    public static void main(String[] args) {
        int matrix[][] = {{1,5,9},{10,11,13},{12,13,15}}, k = 8;
        System.out.println("Kth smallest element in a sorted matrix is :"+kthSmallest(matrix,k));

    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int res = -1;
        while(low<=high){
            int guess = (low + high)/2;
            int ans = fun(matrix, n, guess);
            if(ans < k){
                low = guess + 1;
            }else{
                res = guess;
                high = guess - 1;
            }
        }return res;
    }

    public static int fun(int arr[][], int n, int guess){
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col < n){
            if(arr[row][col] <= guess){
                count += row + 1;
                col++;
            }else{
                row--;
            }
        }return count;
    }
}
