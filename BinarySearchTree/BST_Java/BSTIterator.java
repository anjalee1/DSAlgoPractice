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
class BSTIterator {
    
    private Stack<TreeNode> stack = new  Stack<TreeNode>(); 
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tmpNode= stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            node=node.left;
            
        }
        
    }
}
//bstIterator using inorder morris in o(1) space and time: https://www.youtube.com/watch?v=SeYBu-dy51o
//tc : o(1)

//sc :o(H)

//vid : https://www.youtube.com/watch?v=D2jMcmxU4bs

//ide: https://leetcode.com/problems/binary-search-tree-iterator/
