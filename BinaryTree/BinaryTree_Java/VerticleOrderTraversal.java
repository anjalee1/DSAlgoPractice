
//solution for leetcode
//ide: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
//solution:https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/595226/JAVA-3ms-time-HashMap-bfs-queue

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    class Point {
        TreeNode node;
        int row; 
        int col; 

        Point(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        List<Point> points = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();
        
        q.offer(new Point(root, 0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();
            points.add(p); 

            if (p.node.left != null) {
                q.offer(new Point(p.node.left, p.row - 1, p.col + 1));
            }
            if (p.node.right != null) {
                q.offer(new Point(p.node.right, p.row + 1, p.col + 1));
            }
        }

        // Step 2: Global Sort - O(N log N)
        // Sort by: Vertical Column (row) -> Level (col) -> Value
        Collections.sort(points, (p1, p2) -> {
            if (p1.row != p2.row) return p1.row - p2.row;
            if (p1.col != p2.col) return p1.col - p2.col;
            return p1.node.val - p2.node.val;
        });

        // Step 3: Group by Vertical Column (row) to build result
        // Since it's sorted, we can just iterate through.
        List<Integer> currentColumn = new ArrayList<>();
        if (!points.isEmpty()) {
            currentColumn.add(points.get(0).node.val);
            
            for (int i = 1; i < points.size(); i++) {
                // If this node has a different 'row' than the previous, start a new list
                if (points.get(i).row != points.get(i-1).row) {
                    ans.add(currentColumn);
                    currentColumn = new ArrayList<>();
                }
                currentColumn.add(points.get(i).node.val);
            }
            ans.add(currentColumn); // Add the last column
        }

        return ans;
    }
}

//BFS Traversal (Queue Logic)You are performing a standard Breadth-First Search (BFS) using a Queue. Each node is visited exactly once and added to the points list.Time Complexity: $O(N)$2.
 Global Sorting This is the most expensive part of your algorithm. You are using Collections.sort on a list containing all $N$ nodes.
The comparator checks three conditions (column, row, and value), but each comparison is $O(1)$.
Time Complexity: $O(N \log N)$3
Grouping into Result ListYou iterate through the sorted points list exactly once to group nodes with the same row (vertical column) into the final List<List<Integer>>.
Time Complexity: $O(N)$Total 
Time ComplexityThe overall complexity is dominated by the sorting step:$$T(n) = O(N) + O(N \log N) + O(N) = \mathbf{O(N \log N)}$$
























//pepcoding solution without sorting and not for leetcode
//sol: https://www.youtube.com/watch?v=LscPXvD1N1A&t=1413s
//tc: o(n)
//sc:o(n)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public static class pair{
        TreeNode node=null;
        int Hl=0;
        pair(TreeNode node ,int Hl){
            this.node=node;
            this.Hl=Hl;
            
        }

    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<pair> que = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        int minHl=0,maxHl=0;
        
        List<List<Integer>> ans= new ArrayList<>();
        que.add(new pair(root,0));
        
        while(que.size() != 0){
            int size=que.size();
            
            while(size-->0){
                pair rp=que.remove();
                
                minHl= Math.min(minHl,rp.Hl);
                maxHl= Math.max(maxHl,rp.Hl);
                
                map.putIfAbsent(rp.Hl,new ArrayList<>());
                map.get(rp.Hl).add(rp.node.val);
                
                if(rp.node.left!=null) que.add(new pair(rp.node.left,rp.Hl-1));
                if(rp.node.right!=null) que.add(new pair(rp.node.right,rp.Hl+1));                       
            
             }
         }
        
        for(int i=minHl;i<=maxHl;i++){
            
            ans.add(map.get(i));
            
        }
        
        return ans;
                                
  }
                               
}

                                
