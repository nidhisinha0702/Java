package TwoPointer;

public class ContainerWithMaxWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println("container with max water : "+maxAreaII(height));
	}
	//TC->O(n^2)
	private static int maxArea(int[] height) {
        int maxArea = 0, n = height.length;

        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int currArea = (j-i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, currArea);
            }
        }return maxArea;
    }
	
	private static int maxAreaII(int[] height) {
        int maxArea = 0, n = height.length;
        int lp = 0, rp = n - 1;
        while(lp < rp){
            int currArea = (rp - lp) * Math.min(height[lp], height[rp]);
            maxArea = Math.max(maxArea, currArea);
            if(height[lp] < height[rp]) lp++;
            else rp--;
        }return maxArea;
    }
}
