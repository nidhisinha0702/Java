package Search;

public class Floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 5, 9, 14, 16, 18};
		int target = 15;
		System.out.println("ceil of target is : "+findFloor(arr, target));
	}
	
	//greatest element smaller or equal to the target
	static int findFloor(int[] arr, int x) {
        // write code here
        int start = 0;
        int end = arr.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] <= x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }return end;
    }
}
