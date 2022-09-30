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
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    static void preorder(TreeNode root, List<Integer> list){
    
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
}
}

// Time Complexity: O(N).
// Reason: We are traversing N nodes and every node is visited exactly once.
// Space Complexity: O(N)
// Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).
