
//here array is used for for diameter because java does not support pass by refernce for primitive values ..so if int was used it would not have changed value of diametr in height function
//that's why array is used because it's and object which can passed as reference 
//..for more refer: https://www.geeksforgeeks.org/g-fact-31-java-is-strictly-pass-by-value/

// Time Complexity: O(N) 
// Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )  

//ide:https://leetcode.com/problems/diameter-of-binary-tree/
//sol: https://www.youtube.com/watch?v=Rezetez59Nk


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
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];      
        
    }
    
     private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
