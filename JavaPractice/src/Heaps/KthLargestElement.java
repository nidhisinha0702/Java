package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int arr[] = {12,3,5,7,19};
		int k = 2;
		System.out.println(kthLargest(arr,k));

	}
	
	public static int kthLargest(int[] arr, int k) {
		
		//min-heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//iterate through the array
		for(int val : arr) {
			pq.add(val);
			if(pq.size() > k)
				pq.poll();
		}
		
		return pq.peek();
	}

}
