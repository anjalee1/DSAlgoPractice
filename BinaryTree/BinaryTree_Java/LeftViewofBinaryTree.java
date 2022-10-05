
import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
         ArrayList<Integer> ans= new ArrayList<>();
       if(root==null) return ans;
      
       Queue<TreeNode<Integer>> q  = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            int size=q.size();
            ans.add(q.peek().data);
            while(size-->0){
                TreeNode<Integer> node=q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);  
            }
        }
        return ans;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N) 
// IDE : https://www.codingninjas.com/codestudio/problems/920519?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
// SOL: https://www.youtube.com/watch?v=QTWQSgD9HJ8
  
//method -2 Recursion 
// Time Complexity: O(N)
// Space Complexity: O(H)  (H -> Height of the Tree)
  
// SOL: https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26
// https://takeuforward.org/data-structure/right-left-view-of-binary-tree/


import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static void leftView(TreeNode<Integer> curr, ArrayList<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }
        
        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);
    }
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
       ArrayList<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }
}

