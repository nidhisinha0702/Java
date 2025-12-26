package Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		int edges[][] = {{0,1},{1,2},{2,3},{3,3}};
		
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int edge[]:edges) {
			int u = edge[0];
			int v = edge[1];
			adj.get(u).add(v);
		}
		//System.out.println(adj);
		System.out.println(isCycle(V, adj));

	}
	
	public static boolean isCycleDirDFS(int curr, int vis[], int recPath[], List<List<Integer>> adj) {
		vis[curr] = 1;
		recPath[curr] = 1;
		
		for(int v: adj.get(curr)) {
			if(vis[v] == 0) {
				if(isCycleDirDFS(v, vis, recPath, adj) == true) 
					return true;
				}  // if the node has been previously visited
	            // but it has to be visited on the same path 
				else if(recPath[v]==1) {
					return true;
				}
		}
		recPath[curr] = 0;
		return false;
	}
	
	static boolean isCycle(int n, List<List<Integer>> adj) {
		int vis[] = new int[n];
		int recPath[] = new int[n];
		
		for(int i=0;i<n;i++) {
			if(vis[i] == 0) {
				if(isCycleDirDFS(i, vis, recPath, adj) == true)
					return true;
			}
		}return false;
	}
}
