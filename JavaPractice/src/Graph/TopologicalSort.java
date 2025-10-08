package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		int V = 4, E = 3, edges[][] = {{3,0},{1,0},{2, 0}};
		 List<List<Integer>> adj = new ArrayList<>();
	        
	        for(int i=0;i<V;i++){
	            adj.add(new ArrayList<>());
	        }
	        
	        for(int edge[]:edges){
	            int u = edge[0];
	            int v = edge[1];
	            
	            adj.get(u).add(v);
	        }
	        
	        int[] sort = topoSort(V, adj);
	        System.out.println(Arrays.toString(sort));
	}
	
	public static void dfs(int curr, int vis[], Stack<Integer> st, List<List<Integer>> adj) {
		vis[curr] = 1;
		
		for(int v : adj.get(curr)) {
			if(vis[v] == 0) {
				dfs(v, vis, st, adj);
			}
		}
		
		st.push(curr);
	}
	
	public static int[] topoSort(int V, List<List<Integer>> adj) {
		int vis[] = new int[V];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<V;i++) {
			if(vis[i] == 0) {
				dfs(i, vis, st, adj);
			}
		}
		
		int ans[] = new int[V];
		int i = 0;
		while(!st.isEmpty()) {
			ans[i++] = st.pop();
		}
		return ans;
	}
}
