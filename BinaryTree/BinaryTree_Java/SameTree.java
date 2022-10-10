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
    public boolean isSameTree(TreeNode p, TreeNode q) {
         if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        
        return ((p.val == q.val) && isSameTree(p.left, q.left) && 
        isSameTree(p.right, q.right));
        
    }
}

//Time Complexity: O(N).
//Reason: We are doing a tree traversal.
//Space Complexity: O(N)
//Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).

//ide:https://leetcode.com/problems/same-tree/
//sol:https://www.youtube.com/watch?v=BhuvF_-PWS0
