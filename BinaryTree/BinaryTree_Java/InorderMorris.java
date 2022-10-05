
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
    public List<Integer> inorderTraversal(TreeNode root) {
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
                  curr = curr.left;
                } else { // thread Break
                  rmost.right = null;
                  ans.add(curr.val);
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
