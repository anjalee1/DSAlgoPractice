/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return constructTree(nums,0,nums.length-1);
        
    }
    
   public TreeNode constructTree(int[] nums,int left, int right){
       if(left>right) return null;
       
       int mid=left+(right-left)/2;
       
       TreeNode node= new TreeNode(nums[mid]);
       node.left=constructTree(nums,left, mid-1);
       node.right=constructTree(nums,mid+1,right);
       
       return node;
   }
}

//ide: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//sol: https://www.youtube.com/watch?v=12omz-VAyRk
//https://www.youtube.com/watch?v=UAsLKuEMhsQ&t=89s

//TC: o(n)  https://www.youtube.com/watch?v=UmJT3j26t1I
//SC:o(n)Convert Sorted Array to Binary Search Tree

//Binary Search Tree: https://www.programiz.com/dsa/balanced-binary-tree
