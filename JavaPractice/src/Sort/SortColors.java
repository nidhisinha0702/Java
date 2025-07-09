package Sort;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,0,2,1,1,0,1,2,0,0};
		sortColorsDNF(arr);
		System.out.println(Arrays.toString(arr));

	}
	public static void sortColors(int[] nums) {
        int n = nums.length;
        int zeros = 0, ones = 0, twos = 0;
        //O(n)
        for(int i=0;i<n;i++){
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) ones++;
            else twos++;
        }
        //override the array element
        int idx = 0;
        for(int i=0;i<zeros;i++){
            nums[idx++]=0;
        }
        for(int i=0;i<ones;i++){
            nums[idx++]=1;
        }
        for(int i=0;i<twos;i++){
            nums[idx++]=2;
        } 
    }
	//O(n)->single pass Dutch National Flag Algorithm
	public static void sortColorsDNF(int[] nums) {
        int n = nums.length;
        //unsorted part mid to high
        int low = 0, mid = 0, high = n-1;
        //DNF
        while(mid <= high){
        	//0's -> 0 - low-1
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++; mid++;
            }
            //1's -> low - mid-1
            else if(nums[mid] == 1)
            mid++;
            //2's -> high+1 - n-1
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
