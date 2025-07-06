package Arrays;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,5,4};
		nextPermutation(arr);
		System.out.println("next permutation is : "+Arrays.toString(arr));

	}
	static void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        //step 1. find the pivot
        int pivot = -1;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                pivot = i;
                break;
            }
        }
        //edge case
        if(pivot == -1){
            int st = 0, end = n-1;
            reverse(arr, st, end);
            return;
        }
        
        //step2. find next greater element than pivot
        for(int i = n-1;i>pivot;i--){
            if(arr[i] > arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }
        
        //step 3. reverse the pivot+1 to n-1 elements
        int i= pivot+1, j=n-1;
        reverse(arr, i, j);
        
    }
    
    private static void reverse(int arr[], int st, int end){
        while(st<=end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }

}
