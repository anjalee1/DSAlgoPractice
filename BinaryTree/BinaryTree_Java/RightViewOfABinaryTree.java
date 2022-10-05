
//method 1 iteration
// Time Complexity: O(N)
// Space Complexity: O(N) 
  //sol: Anjali
//ide: https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
          if(root==null) return ans;

           Queue<TreeNode> q  = new LinkedList<>();
            q.add(root);
            while(q.size()!=0){
                int size=q.size();
                ans.add(q.peek().val);
                while(size-->0){
                    TreeNode node=q.remove();
                    if(node.right!=null) q.add(node.right);
                     if(node.left!=null) q.add(node.left);
                }
            }
            return ans;       
    }
    
   
}
  
  
  
  
  
  
  //Method -2 Recursion 
// Time Complexity: O(N)
// Space Complexity: O(H) 
// Sol: https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26
// https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        rightView(root,ans,0);
        return ans;        
    }
    
   public void rightView(TreeNode curr,List<Integer> ans,int level){
       if(curr==null){
           return;
       }
       
       if(level==ans.size()){
           ans.add(curr.val);
       }
       
       rightView(curr.right,ans,level+1);
       rightView(curr.left,ans,level+1);
       
       
   }
}
