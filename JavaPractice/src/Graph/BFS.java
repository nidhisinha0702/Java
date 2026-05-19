package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int node = q.remove();
            result.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int neigh = adj.get(node).get(i);
                if(vis[neigh]==false){
                    q.offer(neigh);
                    vis[neigh]=true;
                }
            }
        }
        return result;
    }
}
