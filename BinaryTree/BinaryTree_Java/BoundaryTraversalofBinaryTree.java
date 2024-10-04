//Time Complexity: O(N).
//Reason: The time complexity will be O(H) + O(H) + O(N) which is ≈ O(N)
//Space Complexity: O(N)
//Reason: Space is needed for the recursion stack while adding leaves. In the worst case (skewed tree), space complexity can be O(N).

//ide: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
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

class Solution {
    ArrayList <Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (!isLeaf(node)) ans.add(node.data);
        
        // Add the left boundary
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
        
        // Add the leaf nodes
        addLeaves(node, ans);
        
        // Add the right boundary in reverse
        curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        // Reverse the right boundary before adding
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
        
        return ans;
    }

    boolean isLeaf(Node node) {
        return (node.left == null) && (node.right == null);
    }

    void addLeaves(Node root, List<Integer> ans) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            
            if (isLeaf(curr)) {
                ans.add(curr.data);
            } else {
                // Push right child first so that left is processed first
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
    }
}


