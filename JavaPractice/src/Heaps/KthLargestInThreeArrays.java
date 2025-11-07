package Heaps;

import java.util.PriorityQueue;

public class KthLargestInThreeArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,3,5,7,9};
		int arr2[] = {2,4,6,8,10};
		int arr3[] = {0,11,12,13,14};
		int k = 5;
		
		int kthLargest = findKthLargest(arr1, arr2, arr3, k);
		System.out.println("The "+k+"-th largest element is: "+kthLargest);

	}
	
	public static int findKthLargest(int[] arr1, int[] arr2, int[] arr3, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		//add elements from arr1
		for(int num:arr1) {
			minHeap.offer(num);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		//add elements from arr2
		for(int num : arr2) {
			minHeap.offer(num);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		//add elements from arr3
		for(int num:arr3) {
			minHeap.offer(num);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.peek();
	}

}
