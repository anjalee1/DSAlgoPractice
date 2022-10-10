

// Time Complexity: O(N)   
// Space Complexity: O(N)

//ide: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//sol: https://www.youtube.com/watch?v=3OXWEdlIGl4
//https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
         Queue <TreeNode> q= new LinkedList<>();
         List<List<Integer>> list = new ArrayList<>();
    
        if (root == null) return list;

        q.add(root);
        boolean flag = true;
        
        while (!q.isEmpty()){
           int levelNum = q.size();
           List<Integer> level = new ArrayList<>();
           
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.remove(); 
                if (node.left!= null) {
                    q.add(node.left);
                }
                if(node.right!= null){
                      q.add(node.right);
                }
                
                if (flag == true) level.add(node.val);
                else level.add(0, node.val);
                
                
            }
           
            flag = !flag;
            list.add(level);
        }
        
        return list;
        
        
        
    }
}
