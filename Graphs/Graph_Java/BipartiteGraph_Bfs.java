
//ide:https://leetcode.com/problems/is-graph-bipartite/
//sol:https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18
//https://takeuforward.org/graph/bipartite-graph-bfs-implementation/
//https://leetcode.com/problems/is-graph-bipartite/discuss/115487/Java-Clean-DFS-solution-with-Explanation
//Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.
// Space Complexity: O(3V) ~ O(V), Space for queue data structure, colour array and an adjacency list.


class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

