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
     int idx=0;
     public TreeNode constructbst(int[] preorder,int lr,int rr){
         if(idx>=preorder.length || preorder[idx] <lr|| preorder[idx] >rr){
             return null;
         }
         TreeNode node=new TreeNode(preorder[idx++]);
         node.left=constructbst(preorder,lr,node.val);
         node.right=constructbst(preorder,node.val,rr); 
         return node;
     }
    
    public TreeNode bstFromPreorder(int[] preorder) {
         if(preorder == null) {
            return null;
        }
        int n =preorder.length;
        return constructbst(preorder,Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    
  
}


//ide: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//sol:https://www.youtube.com/watch?v=Bexswo4pqZQ

// Time Complexity: O(N)
//sc: o(n)
