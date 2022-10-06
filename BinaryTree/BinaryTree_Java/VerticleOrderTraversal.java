
//solution for leetcode
//ide: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
//solution:https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/595226/JAVA-3ms-time-HashMap-bfs-queue

class Solution {
    
    class Group{
            TreeNode treeNode;
            int row;
            int col;
            Group(TreeNode treeNode, int row, int col){
                this.treeNode = treeNode;
                this.row = row;
                this.col = col;
            }
        }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();        
        if(root == null) {
            return res;
        }
        
        HashMap<Integer,List<Group>> colMap = new HashMap<>();
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        Queue<Group> q = new ArrayDeque<>();
        q.add(new Group(root, 0 , 0));
        
        while(!q.isEmpty()) {
            Group node = q.poll();

            int row = node.row;
            int col = node.col;
            
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            
             colMap.putIfAbsent(node.col,new ArrayList<>());
             colMap.get(node.col).add( node);
            
            if(node.treeNode.left != null) {
                q.add(new Group(node.treeNode.left, row + 1, col-1 ));
            }
            
            if(node.treeNode.right != null) {
                q.add(new Group(node.treeNode.right, row + 1, col+1 ));
            }
            
            
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = minCol ; i <=maxCol; i++ ) {
            List<Group> list = colMap.get(i);            
            Collections.sort(list, (a, b) -> {
                if( a.row == b.row)   
                    return a.treeNode.val - b.treeNode.val ;
                else
                    return a.row - b.row;
            });
            
            List<Integer> values = new ArrayList<>();
            
            for(Group g: list) {
                values.add(g.treeNode.val);
            }
            
            ans.add(values);
        }
    
        return ans;
    }
}


























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

                                
