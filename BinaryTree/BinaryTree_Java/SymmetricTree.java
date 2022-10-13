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
    public static boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricUtil(root.left, root.right);
        
    }
    
    public static boolean isSymmetricUtil(TreeNode root1,TreeNode root2){
        
        if(root1==null || root2==null){
            return root1==root2;
        }
        
        
        return (root1.val ==root2.val) && isSymmetricUtil(root1.left,root2.right)
            && isSymmetricUtil(root1.right,root2.left);
    }
}

//ide: https://leetcode.com/problems/symmetric-tree/
//sol: https://www.youtube.com/watch?v=nKggNAiEpBE

//Time Complexity: O(N)
//Reason: We are doing simple tree traversal and changing both root1 and root2 simultaneously.
//Space Complexity: O(N)
//Reason: In the worst case (skewed tree), space complexity can be O(N).
