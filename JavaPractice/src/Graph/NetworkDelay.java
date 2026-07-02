package Graph;
import java.util.*;

public class NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adj list 1-based indexing
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        result[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.first;
            int d = p.second;

            if (d > result[u])
                continue;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).first;
                int wt = adj.get(u).get(i).second;

                if (wt + result[u] < result[v]) {
                    result[v] = wt + result[u];
                    pq.offer(new Pair(v, wt + result[u]));
                }
            }

        }
        //The minimum time it takes for all the n nodes to receive the signal.
        int minTime = 0;
        for (int i = 0; i <= n; i++) {
            if (result[i] == Integer.MAX_VALUE)
                return -1;
            else if (minTime < result[i])//maximum time in which signal will be received
                minTime = result[i];

        }
        return minTime;
    }

    static class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }
}

