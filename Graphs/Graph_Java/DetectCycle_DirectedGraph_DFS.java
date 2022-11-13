
//ide: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol: https://www.youtube.com/watch?v=uzVUw90ZFIg&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=13
//https://takeuforward.org/data-structure/detect-a-cycle-in-directed-graph-using-dfs/

//tc: o(v+e)
//sc: o(2v) 2 visited array
//as:o(v) recursion

//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    
    private static boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;
       
        for(Integer neighbor: adj.get(node)) {
        	if(vis[neighbor] == 0) {
                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {
                	return true;
            	}
        	} else if(dfsVis[neighbor] == 1) {
            	return true;
        	}
        }
        dfsVis[node] = 0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int dfsVis[] = new int[V];
       
        for(int i = 0;i<V;i++) {
        	if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
        	}
        }
        return false;
    }
}
