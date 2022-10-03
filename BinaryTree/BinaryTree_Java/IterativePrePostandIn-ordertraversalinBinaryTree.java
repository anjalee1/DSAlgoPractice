//Time Complexity: O(N)
//Reason: We are visiting every node thrice therefore time complexity will be O(3*N), which can be assumed as linear time complexity
//Space Complexity: O(N)
//Reason: We are using three lists and a stack to store the nodes. The time complexity will be about O(4*N), which can be assumed as linear time complexity.

//ide: https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    static class Pair{
        BinaryTreeNode<Integer> node ;
        int state;
        Pair(BinaryTreeNode<Integer> node, int state) {
             this.node = node;
             this.state = state;
        }
    }
    
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
       
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List < Integer > pre = new ArrayList < > ();
        List < Integer > in = new ArrayList < > ();
        List < Integer > post = new ArrayList < > ();
        Stack<Pair> st = new Stack<>();
        Pair first=new Pair(root,1);
        st.push(first);
        while(!st.isEmpty()){
            Pair pair= st.peek();
            if(pair.state==1){
                pre.add(pair.node.data);
                pair.state++;
                
                if (pair.node.left != null) {
                    st.push(new Pair(pair.node.left, 1));
                }
            }
            else if(pair.state ==2){
                 in.add(pair.node.data);
                 pair.state++;
                
                if (pair.node.right!= null) {
                    st.push(new Pair(pair.node.right, 1));
                }
            }
            else{
               post.add(pair.node.data);
               st.pop();
            }
        }
       
        
        res.add(in);
        res.add(pre);
        res.add(post);
        
        return res;
    }
}
