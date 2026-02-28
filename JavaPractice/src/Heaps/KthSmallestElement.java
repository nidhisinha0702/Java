package Heaps;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int  arr[] = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, k = 4;
        System.out.println("kth smallest element is : "+kthSmallest(arr, k));
    }
    public static int kthSmallest(int[] arr, int k) {
        // Create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int n = arr.length;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }

        }
        return pq.peek();
    }
}
