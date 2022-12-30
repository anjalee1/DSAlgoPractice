//ide:https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
//sol:https://www.youtube.com/watch?v=wuVwUK25Rfc&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=60
//https://takeuforward.org/data-structure/m-coloring-problem/

//Time Complexity: O( N^M) (n raised to m)
//Space Complexity: O(N)

//graph boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false },
        };  
//https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
         int[] color = new int[n];
         if (solve(0, graph, color, n, m) == true) return true;
        return false;
    }
    private static boolean isSafe(int node, boolean graph[][], int[] color, int n, int col) {
        for (int i = 0; i < n; i++){
            if (graph[node][i] && color[i] == col)
                return false;
        }
        return true;
    }
    private static boolean solve(int node, boolean graph[][], int[] color, int n, int m) {
        if (node == n) return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(node, graph, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, graph, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }
}
