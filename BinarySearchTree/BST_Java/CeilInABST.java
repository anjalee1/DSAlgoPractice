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

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
        int ceil=-1;
        while(node != null){
           if(node.data==x){
               ceil =node.data;
               return ceil;
           }
           else if(node.data>x){
               ceil=node.data;
               node=node.left ;
           }  
           else{
               node=node.right;
           }
       }
       return ceil;

    }
}
//ide: https://www.codingninjas.com/codestudio/problems/920457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
//sol: https://www.youtube.com/watch?v=KSsk8AhdOZA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43
//tc: o(H) where H= log2N
