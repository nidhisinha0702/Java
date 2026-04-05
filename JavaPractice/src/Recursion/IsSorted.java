package Recursion;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Array is sorted: "+isSorted(arr));
    }
    public static boolean isSorted(int[] arr) {
        // code here
        int n = arr.length;
        return fun(arr, 0, n);
    }

    public static boolean fun(int[] arr, int i, int n){
        //for length 0 and 1 arr is sorted
        if(i == n || i == n-1)
            return true;

        if(arr[i] > arr[i+1])
            return false;

        return fun(arr, i+1, n);
    }
}
