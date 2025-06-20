package Search;

public class SearchInMountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,3,1};
		int target = 3;
		int ans = findInMountainArray(target, arr);
		System.out.println("element is found at idx : "+ans);

	}
	
	public static int findInMountainArray(int target, int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;
        int peakIdx = peakInd(mountainArr, start, end);
        int val = mountainArr[peakIdx];
        if(target == val) return peakIdx;
        int ans = orderAgnosticBS(mountainArr, start, peakIdx-1, target, true);
        if(ans == -1)
        ans = orderAgnosticBS(mountainArr, peakIdx+1, end, target, false);
        return ans;
    }

    private static int orderAgnosticBS(int[] mountainArr, int start, int end, int target, boolean isAsc){
        while(start <= end){
            int mid = start + (end - start)/2;
            int val = mountainArr[mid];
            if(target == val){
                return mid;
            }else{
                if(isAsc){
                    if(target < val){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }else{
                    if(target > val){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }
        }return -1;
    }

    private static int peakInd(int[] mountainArr, int start, int end){
         while(start < end){
            int mid = start + (end - start)/2;
            if(mountainArr[mid] < mountainArr[mid + 1]){
                //asc half
                start = mid + 1;
            }else{
                //desc half
                end = mid;
            }
        }return start;
    }

}
