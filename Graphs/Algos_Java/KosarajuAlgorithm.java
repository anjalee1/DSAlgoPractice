// Time Complexity: O(N+E), DFS+TopoSort
// Space Complexity: O(N+E), Transposing the graph

//sol:https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=28
//https://takeuforward.org/data-structure/kosarajus-algorithm-for-strongly-connected-componentsscc/
//also check this for theory : https://www.youtube.com/watch?v=QtdE7QPsWiU&t=1634s

//ide: https://www.codingninjas.com/codestudio/problems/985311?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0


import java.util.*; 
public class Solution {

    private static void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[node] = 1;
        for(Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, st, adj, vis); 
            }
        }

        st.push(node); 
    }
    
    private static void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int vis[],List<Integer> ans) {
        vis[node] = 1;
         ans.add(node);
        for(Integer it : transpose.get(node)) {
            if(vis[it] == 0) {
                revDfs(it, transpose, vis,ans); 
            }
        }
    }

    
    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        
ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>();
        
        //create adjacency list from edges
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        List<List<Integer>> ans = new ArrayList();
        int vis[] = new int[n]; 
        Stack<Integer> st = new Stack<Integer>(); 
        for(int i = 0;i<n;i++) {
            if(vis[i] == 0) {
                dfs(i, st, adj, vis); 
            }
        }
        
        ArrayList<ArrayList<Integer> > transpose = new ArrayList<ArrayList<Integer> >();
        
        for (int i = 0; i < n; i++) 
            transpose.add(new ArrayList<Integer>());

        for(int i = 0;i<n;i++) {
            vis[i] = 0; 
            for(Integer it: adj.get(i)) {
                transpose.get(it).add(i); 
            }
        }

        while(st.size() > 0) {
            int node = st.peek(); 
            st.pop(); 
            if(vis[node] == 0) {
                List<Integer> ans1 = new ArrayList();
                revDfs(node, transpose, vis,ans1);
                ans.add(ans1);
            }
        }
      return ans;
    }
}
