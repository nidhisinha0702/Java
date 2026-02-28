package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRow {
    public static void main(String[] args) {
        int mat[][] =
                {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}},
        k = 3;
        int[] ans = kWeakestRows(mat,k);
        System.out.println("Kweakest rows is:"+Arrays.toString(ans));
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b)->(a.first!=b.first)?a.first-b.first:a.second-b.second);
        for(int i=0;i<n;i++){
            int cnt_1 = 0;
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1){
                    cnt_1++;
                }
            } minHeap.offer(new Pair(cnt_1,i));
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(k>0){
            res.add(minHeap.peek().second);
            minHeap.poll();
            k--;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    static class Pair{
        int first;//cnt
        int second;//row
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
}
