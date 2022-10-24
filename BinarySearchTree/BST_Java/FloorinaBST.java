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

    public static int floorInBST(TreeNode<Integer> root, int X) {
       int floor=-1;
        TreeNode<Integer> node =root;
       while(node != null){
           if(node.data==X){
               floor =node.data;
               return floor;
           }
           else if(node.data<X){
               floor=node.data;
               node=node.right ;
           }
           
           else{
               node=node.left;
           }
       }
       return floor;
    }
}

//ide: https://www.codingninjas.com/codestudio/problems/920457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
//sol: https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=44
