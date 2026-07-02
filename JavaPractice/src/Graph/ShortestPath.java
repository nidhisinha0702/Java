package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class ShortestPath {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int vis[] = new int[V];
        int res[] = new int[V];
        Arrays.fill(res, -1);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));
        vis[src] = 1;

        while(!q.isEmpty()){

            Pair p = q.poll();
            int node = p.first;
            int dist = p.second;
            res[node] = dist;

            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j);
                if(vis[neigh] == 0){
                    q.offer(new Pair(neigh, dist + 1));
                    vis[neigh] = 1;
                }
            }
        }
        return res;
    }
}
class Pair{
    int first, second;
    Pair(int f, int s){
        first = f;
        second = s;
    }
}
