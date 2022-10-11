//Time Complexity: O(N).
//Reason: The time complexity will be O(H) + O(H) + O(N) which is ≈ O(N)
//Space Complexity: O(N)
//Reason: Space is needed for the recursion stack while adding leaves. In the worst case (skewed tree), space complexity can be O(N).

//ide: https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?leftPanelTab=0
//sol: https://www.youtube.com/watch?v=0ca1nvR0be4
//https://takeuforward.org/data-structure/boundary-traversal-of-a-binary-tree/

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    
    public static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
    
    public static void addLeftBoundary(TreeNode root, ArrayList < Integer > res) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (isLeaf(cur) == false) res.add(cur.data);
            if (cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }
    
   public static void addRightBoundary(TreeNode root, ArrayList < Integer > res) {
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }
    
     public static void addLeaves(TreeNode root, ArrayList < Integer > res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList < Integer > ans = new ArrayList < Integer > ();
        if (isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
	}
}
