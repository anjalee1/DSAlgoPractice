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
 
    public boolean isBalanced(TreeNode root) {
      return dfsHeight (root) != -1;
    }
    
    
    public int dfsHeight (TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}

//Time Complexity: O(N) 
//Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree) 

//ide: https://leetcode.com/problems/balanced-binary-tree/
//sol: https://www.youtube.com/watch?v=Yt50Jfbd8Po
