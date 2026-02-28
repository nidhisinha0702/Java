package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};

        ArrayList<Integer> ans = mergeArrays(mat);
        System.out.println("after sorted :"+ans);
    }
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                minHeap.offer(mat[i][j]);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.peek());
            minHeap.poll();
        }
        return res;
    }
}
