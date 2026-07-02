package Graph;
import java.util.*;

public class Dijkstra {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        //fill list of list
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        //fill values list{list{pair(node, distance)}}
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        //min heap (pairs{node, distance}) as we need smallest distance from single source
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->a.second-b.second);

        //start with source node and 0 distance
        minHeap.offer(new Pair(src, 0));

        //create distance array to return
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);//fill with max value in all
        dist[src] = 0;//assign source to 0

        //iterate until q is empty
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();//pop 1 by 1

            int node = p.first;
            int distance = p.second;

            if(distance > dist[node]) // if current distance is greater than the distance in the array continue
                continue;

            //iterate on all the neighbors
            for(int j=0;j<adj.get(node).size();j++){
                int neigh = adj.get(node).get(j).first;
                int dis = adj.get(node).get(j).second;

            // if distance of neigh is greater than the current distance + distance till now
                if(dis + dist[node] < dist[neigh]){
                    dist[neigh] = dis + dist[node];//update the new distance
                    minHeap.offer(new Pair(neigh, dis + dist[node]));//push in q

                }
            }
        }

        return dist;
    }
    static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
}
