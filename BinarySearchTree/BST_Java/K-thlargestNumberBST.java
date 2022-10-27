
/*
    Time Complexity: O(N)
    Space Complexity: O(N)

    where 'N' is the total number of nodes of the BST.
    
    ide: https://www.codingninjas.com/codestudio/problems/920438?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
    sol: https://www.youtube.com/watch?v=9TJYWh0adfk
*/
    
import java.util.ArrayList;

public class Solution {
	public static int revInorder(TreeNode < Integer > root, int [] visCount, int k)
	{
		if (root == null)
		{
			return -1;
		}
		
		// Recurse over right subtree. 
		int right = revInorder(root.right, visCount, k);
	    
	    if (right != -1)
	    {
	    	return right;
	    }

		visCount[0]++;

		if (visCount[0] == k)
		{
			return root.data;
		}

		// Recurse over left subtree.
		int left = revInorder(root.left, visCount, k);
	    
	    return left;
	}


	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		int[] visCount = new int [1];

		return revInorder(root, visCount, k);
	}
}
