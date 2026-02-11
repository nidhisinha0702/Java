package Search;
import java.util.Arrays;
public class AggressiveCows {
    public static void main(String[] args) {
        int stalls[] = {10, 1, 2, 7, 5}, k = 3;
        System.out.println("We can place all the cows at a minimum distance of "+aggressiveCows(stalls,k));
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        int ans = -1;

        while(low <= high){
            int guess = low + (high - low)/2;

            if(canPlaceCows(stalls, n, k, guess)){
                ans = guess;
                low = guess + 1;
            }else{
                high = guess - 1;
            }
        }return ans;
    }

    public static boolean canPlaceCows(int arr[], int n, int k , int guess){
        int cow = 1;
        int prevPos = arr[0];
        for(int i=0;i<n;i++){
            int dist = arr[i] - prevPos;
            if(dist < guess)
                continue;
            cow++;
            prevPos = arr[i];
        }
        return (cow >= k)?true:false;
    }
}
