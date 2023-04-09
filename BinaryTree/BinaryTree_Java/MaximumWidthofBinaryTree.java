//IDE: https://leetcode.com/problems/maximum-width-of-binary-tree/
//SOL: https://www.youtube.com/watch?v=R9qiY7OK9JQ

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
    
    public static class Pair{
        TreeNode node =null;
        int idx =0;
        
        Pair(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;   
        }
        
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> que= new LinkedList<>();
        int max=0;
        que.add(new Pair(root,0));
        while(que.size() != 0){
            int size =que.size();
            
            int lm =que.peek().idx;
            int rm = que.peek().idx;
            
            while(size-->0){
                
                Pair rp =que.remove();
                rm=rp.idx;
                
                if(rp.node.left != null) que.add(new Pair(rp.node.left,rp.idx*2+1));
                if(rp.node.right != null) que.add(new Pair(rp.node.right,rp.idx*2+2));
                   
                
            }
            
            max=Math.max(max,rm-lm+1);
        }
        
        return max;
        
        
        
    }
}
