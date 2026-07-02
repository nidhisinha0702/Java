package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {
    public static void main(String[] args) {
        int V = 4, E = 3, edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(V, edges));
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            ArrayList<Integer> inner = new ArrayList<>();
            adj.add(inner);
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);

            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j);
                indegree[neigh]--;

                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return result;
    }
}
