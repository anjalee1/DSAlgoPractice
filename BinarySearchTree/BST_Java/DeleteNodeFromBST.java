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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null) return null;
        
        if(key<root.val){                            
            root.left = deleteNode(root.left,key);
            return root;
        }
        
        else if(key>root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }
        
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode max = root.left;
                while(max.right!=null){
                    max = max.right;
                }
                
                root.val = max.val;
                root.left = deleteNode(root.left,max.val);
                return root;
            }
        }
        
    }
}


//ide: https://leetcode.com/problems/delete-node-in-a-bst/
//sol: https://www.youtube.com/watch?v=5_AZcOOc-kM&t=2s
//https://leetcode.com/problems/delete-node-in-a-bst/discuss/1590868/JAVA-or-Recursive-or-Most-Intutive-or-Proper-Explanation-Using-Image

//Time Complexity: The worst case time complexity of delete operation is O(h) where h is the height of the Binary Search Tree. 
//In worst case, we may have to travel from the root to the deepest leaf node.
//The height of a skewed tree may become n and the time complexity of delete operation may become O(n)
