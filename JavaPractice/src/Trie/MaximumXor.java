package Trie;

public class MaximumXor {

	public static void main(String[] args) {
		int arr1[] = {9,8,7,5,4};
		int arr2[] = {8,1,2,12,7};
		int n = arr1.length;
		int m = arr2.length;
		int result = maxXor(n,m, arr1, arr2);
		System.out.println("Max xor value is : "+result);

	}
	
	static int maxXor(int n , int m, int arr1[], int arr2[]) {
		TrieBit trie = new TrieBit();
		
		for(int i=0;i<n;i++) {
			trie.insert(arr1[i]);
		}
		
		int maxXR = 0;
		
		for(int i=0;i<m;i++) {
			maxXR = Math.max(maxXR, trie.getMax(arr2[i]));
		}
		return maxXR;
	}
}
