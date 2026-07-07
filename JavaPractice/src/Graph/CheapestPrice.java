package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class CheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int flight[] : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            adj.get(u).add(new Pair(v,wt));
        }
        //as we are bounded to use k stops it will increase 1 by 1 hence queue is sufficient
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src, 0));

        int res[] = new int[n];
        Arrays.fill(res, (int)1e8);
        res[src] = 0;


        while(!q.isEmpty()){
            Tuple p = q.poll();
            int stops = p.first;
            int u = p.second;
            int wt = p.third;

            if(stops > k) continue;

            for(int j=0;j<adj.get(u).size();j++){
                int v = adj.get(u).get(j).first;
                int price = adj.get(u).get(j).second;


                if(wt + price < res[v] && stops <= k){
                    res[v] = wt + price;
                    q.add(new Tuple(stops + 1, v, wt  + price));
                }
            }
        }
        return (res[dst] == (int)1e8) ? -1 : res[dst];

    }static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    static class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
