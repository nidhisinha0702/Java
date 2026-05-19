package Graph;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean vis[] = new boolean[n];
        dfs(adj,0,vis,result);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[], ArrayList<Integer> result){
        result.add(node);
        vis[node] = true;

        for(int i=0;i<adj.get(node).size();i++){
            int neigh = adj.get(node).get(i);
            if(vis[neigh] == false)
                dfs(adj,neigh,vis,result);
        }
        return;
    }
}
