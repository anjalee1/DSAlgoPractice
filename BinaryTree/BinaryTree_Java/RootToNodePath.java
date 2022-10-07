Time Complexity: O(N)
Reason: We are doing a simple tree traversal.
Space Complexity: O(N)
Reason: In the worst case (skewed tree), space complexity can be O(N).
  
 //ide: https://www.interviewbit.com/problems/path-to-given-node/
  //sol:https://www.youtube.com/watch?v=fmflMqVOC7k
 // https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/
  
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        
        ArrayList<Integer> arr =new ArrayList<>(); 
        if(A==null) return new int[0];
        getPath(A,arr,B);
        int res[] = new int[arr.size()];
        for(int i=0; i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res; 
        
    }
    
    public boolean getPath(TreeNode node,ArrayList<Integer> arr,int data){
        if(node==null) return false;
        
        arr.add(node.val);
        
        if (node.val == data)
            return true;
        
        if (getPath(node.left, arr, data) ||
            getPath(node.right, arr, data))
            return true;
            
        arr.remove(arr.size() - 1);
        return false;
        
    }
    
}
