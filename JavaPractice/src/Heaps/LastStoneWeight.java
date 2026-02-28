package Heaps;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println("The last stone weight is : "+lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);
        int n = stones.length;
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while(!maxHeap.isEmpty() && maxHeap.size()>=2){
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            int z = y-x;
            if(z>0){
                maxHeap.offer(z);
            }
        }
        if(maxHeap.isEmpty()) return 0;
        return maxHeap.peek();
    }
}
