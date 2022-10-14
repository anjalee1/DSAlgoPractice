//ide:https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//sol:https://www.youtube.com/watch?v=fnmisPM6cVo
//https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/

// Time Complexity: O(N)
// Reason: We are doing a simple tree traversal.
// Space Complexity: O(N)
// Reason: In the worst case( skewed tree), space complexity can be O(N).

import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
       if (root == null) return;
      int child = 0;
      if (root.left!=null) {
        child += root.left.data;
      }
      if (root.right!=null) {
        child += root.right.data;
      }

      if (child < root.data) {
        if (root.left!=null) root.left.data = root.data;
        else if (root . right!=null) root.right.data = root.data;
      }

      changeTree(root.left);
      changeTree(root.right);

      int tot = 0;
      if (root.left!=null) tot += root.left.data;
      if (root.right!=null) tot += root.right.data;
      if (root.left!=null || root.right!=null) root.data = tot;
    }
}
