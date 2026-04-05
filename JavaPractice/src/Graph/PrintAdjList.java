package Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjList {
    public static void main(String[] args) {
        int V = 5, E = 7;
        int[][] edges = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};
        System.out.println("Adjacency list is : "+printGraph(V, edges));
    }
    public static List<List<Integer>> printGraph(int V, int edges[][]) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
