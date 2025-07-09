package Search;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,5,6,6,6,67,0,1,2};
		int tar = 0;
		System.out.println("element is found at : "+search(arr,tar));

	}
	private static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            //if found
            if(nums[mid] == target) return mid;
            
            if(nums[start] <= nums[mid]){
                //1st sorted half
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                //2nd half is sorted
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }return -1;
    }

}
