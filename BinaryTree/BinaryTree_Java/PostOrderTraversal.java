
// Time Complexity: O(N).
// Space Complexity: O(N)
  
  
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    static void postorder(TreeNode root, List<Integer> list){
    
        if(root == null) return;
      
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
}
}

//Iterative approach
//Time Complexity: O(N).
//Reason: We are traversing N nodes and every node is visited exactly once.
//Space Complexity: O(N+N)

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode el=s1.pop();
            s2.push(el);
            
            if(el.left!=null){
                 s1.push(el.left);
            }
            if(el.right!=null){
                 s1.push(el.right);
            }
           
        }
        
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        
        return list;
       
    }
}
