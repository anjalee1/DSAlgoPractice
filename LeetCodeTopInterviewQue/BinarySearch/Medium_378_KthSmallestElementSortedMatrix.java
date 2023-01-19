
//ide : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
//tc: O(r * log(c) * log(MAX - MIN) )
//sc:o(1)
//sol: https://www.youtube.com/watch?v=LkrsdWa69_Q&t=992s

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int r= matrix.length;
       int c = matrix[0].length;

       int startVal=matrix[0][0];
       int endVal=matrix[r-1][c-1];
       int midVal,count;

       while(startVal<=endVal){
           midVal=(startVal+endVal)/2;
           count =countElements(matrix,r,c,midVal);
           if(count<k) startVal=midVal+1;
           else endVal =midVal-1;
       } 
       return  startVal;
    }

    public int countElements(int[][] matrix,int r,int c,int target){
        int count =0;
        for(int i=0;i<r;i++){
            int low=0,high=c-1,mid;
            while(low<=high){
                mid=low+(high-low)/2;
                if(matrix[i][mid]<=target) low=mid+1;
                else high=mid-1;
            }
            count+=low;
        }
        return count;
    }
}
