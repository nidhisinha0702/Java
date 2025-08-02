package Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("water trapped is : "+trap(height));

	}
	 public static int trap(int[] height) {
	        int n = height.length;
	        int ans = 0, l = 0, r = n-1;
	        int lmax = 0, rmax = 0;

	        while(l < r){
	            lmax = Math.max(lmax, height[l]);
	            rmax = Math.max(rmax, height[r]);

	            if(lmax < rmax){
	                ans += lmax - height[l];
	                l++;
	            }else{
	                ans += rmax - height[r];
	                r--;
	            }
	        }
	        return ans;
	    }
}
