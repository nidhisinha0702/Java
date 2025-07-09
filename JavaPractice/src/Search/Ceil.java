package Search;

public class Ceil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 5, 9, 14, 16, 18};
		int target = 15;
		System.out.println("ceil of target is : "+findCeil(arr, target));

	}
	//smallest element greater or equal to the target
	private static int findCeil(int[] arr, int x) {
        // code here
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] >= x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }return start;
        
    }

}
