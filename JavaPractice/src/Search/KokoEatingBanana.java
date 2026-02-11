package Search;
import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int piles[] = {3,6,7,11}, h = 8;
        System.out.println("Koko can eat all banana in "+minEatingSpeed(piles, h)+" hours.");
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            long hour = fun(piles, n, mid);
            if(hour > h){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }return ans;

    }
    public static long fun(int arr[], int n, int hour){
        long h = 0;
        for(int i=0;i<n;i++){
            h += arr[i]/hour;
            if(arr[i] % hour != 0)
                h++;
        }return h;
    }
}
