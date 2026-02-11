package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class MinimumSwap {
    public static void main(String[] args) {
        int arr[] = {2, 8, 5, 4};
        System.out.println("minimum swaps required to sort this array is : "+minSwaps(arr));

    }
    public static int minSwaps(int arr[]) {
        // Code here
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] numSorted = arr.clone();
        Arrays.sort(numSorted);

        for(int i=0;i<n;i++){
            map.put(numSorted[i], i);
        }

        int swap = 0;
        int i= 0;
        while(i <n){
            //if element is at correct indx
            if(map.get(arr[i]) == i){
                i++;
            }else{
                swap++;
                swap(arr, i, map.get(arr[i]));
            }
        }
        return swap;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
