package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKthRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<>(Arrays.asList(5,1,2,3,4));
		System.out.println("array is rotated : "+findKRotation(arr)+" : times.");

	}
	public static int findKRotation(List<Integer> arr) {
        // Code here
        //we need to find the smallest element half and return smallest element index
        int start = 0;
        int end = arr.size() - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            //if the array is not rotated
            if(arr.get(start) <= arr.get(end)){
                return start;
            }
            //if mid + 1 is the smallest element
            if(arr.get(mid) > arr.get(mid + 1)){
                return mid + 1;
            }
            //if mid is the smallest element
            if(arr.get(mid) < arr.get(mid - 1)){
                return mid;
            }
            //if mid > end smallest elemnt will be in right half
            if(arr.get(mid) > arr.get(end)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }return 0;
    }
}
