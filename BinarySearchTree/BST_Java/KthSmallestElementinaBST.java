
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
    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;
        traverse(root.left, k);
        count ++;
        if(count == k) result = root.val;
        traverse(root.right, k);       
    }
}

//ide: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//sol: https://www.youtube.com/watch?v=9TJYWh0adfk


//iterative 

public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode p = root;
     int count = 0;
     
     while(!stack.isEmpty() || p != null) {
         if(p != null) {
             stack.push(p);  // Just like recursion
             p = p.left;   
             
         } else {
            TreeNode node = stack.pop();
            if(++count == k) return node.val; 
            p = node.right;
         }
     }
     
     return Integer.MIN_VALUE;
 }
