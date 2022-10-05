
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
    public List<Integer> preorderTraversal(TreeNode root) {
        
       TreeNode curr = root;
       List<Integer> ans = new ArrayList<>();
     
        while(curr != null){
            TreeNode leftTreeNode = curr.left;
            if (leftTreeNode == null) { // left null
                ans.add(curr.val);
                curr = curr.right;
            } 
            else {
                 TreeNode rmost = rightMostNode(leftTreeNode, curr);
                if (rmost.right == null) { // thread Creation
                  rmost.right = curr;
                  ans.add(curr.val);
                  curr = curr.left;
                } else { // thread Break
                  rmost.right = null;
                  curr = curr.right;
                }
            }
       }
        
       return ans;
    }
    
    public TreeNode rightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
          node = node.right;
        }
        return node;
   }
    
}

// Time Complexity: O(N).
// Space Complexity: O(1)

//ide : https://leetcode.com/problems/binary-tree-preorder-traversal/
//sol: https://www.youtube.com/watch?v=8rwHi5CXwqY
//https://nados.io/question/pre-order-morris-traversal-in-binary-tree
