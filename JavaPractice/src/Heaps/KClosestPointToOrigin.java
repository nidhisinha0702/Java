package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int points[][] = {{1,3},{-2,2}}, k = 1;
        int ans[][] = kClosest(points,k);
        System.out.println("K closest point from origin is :"+Arrays.deepToString(ans));
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>((a, b)->b.third-a.third);
        int n = points.length;
        for(int[] point:points){
            maxHeap.offer(new Tuple(point[0],point[1],point[0] * point[0] + point[1] * point[1]));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        ArrayList<int[]> res = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            res.add(new int[]{maxHeap.peek().first,maxHeap.peek().second});
            maxHeap.poll();
        }
        return res.toArray(int[][]::new);
    }

    static class Tuple{
        int first, second, third;
        Tuple(int f, int s, int t){
            first = f;
            second = s;
            third = t;
        }
    }
}
