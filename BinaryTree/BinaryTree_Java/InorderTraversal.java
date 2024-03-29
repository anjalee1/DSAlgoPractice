
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
        
       List<Integer> list = new ArrayList<>();
       inorder(root, list);
       return list;
        
    }
    
    
    static void inorder(TreeNode root, List<Integer> list){
    
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
}
}

//Time Complexity: O(N).

//Reason: We are traversing N nodes and every node is visited exactly once.

//Space Complexity: O(N)

//Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).





//Iterative approach


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
       List<Integer> list = new ArrayList<>();
       Stack<TreeNode> st= new Stack<>();
        while(true){
            if(curr!=null){
                
                st.push(curr);
                curr=curr.left;
                
            }
            else{
                if(st.isEmpty())break;
                
                curr =st.pop();
                list.add(curr.val);
                curr=curr.right;
            }
        }
        
        return list;
        
    }
    
}


// Time Complexity: O(N).
// Reason: We are traversing N nodes and every node is visited exactly once.
// Space Complexity: O(N)
// Reason: In the worst case (a tree with just left children), the space complexity will be O(N).
