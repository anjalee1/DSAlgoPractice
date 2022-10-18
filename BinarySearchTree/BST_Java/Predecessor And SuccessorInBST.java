/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
        int predecessor = -1;
        int successor = -1;
        
        while (root.data != key)
        {
            if (key > root.data)
            {
                predecessor = root.data;
                root = root.right;
            }
            else
            {
                successor = root.data;
                root = root.left;
            }
        }
        
        BinaryTreeNode < Integer > rightSubtree = root.right;
        while (rightSubtree != null)
        {
            successor = rightSubtree.data;
            rightSubtree = rightSubtree.left;
        }
        
        BinaryTreeNode < Integer > leftSubtree = root.left;
        while (leftSubtree != null)
        {
            predecessor = leftSubtree.data;
            leftSubtree = leftSubtree.right;
        }

        ArrayList < Integer > sol = new ArrayList < Integer > ();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
}

//ide: https://www.codingninjas.com/codestudio/problems/893049?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
