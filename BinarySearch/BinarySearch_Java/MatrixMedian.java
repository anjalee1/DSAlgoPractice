
//https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
//#tutorial video:- https://www.youtube.com/watch?v=tFdBRcHLSGQ
//#ide:https://www.codingninjas.com/codestudio/problems/873378?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//tc : Time Complexity : O(N * log(M) * log(MAX - MIN) )
 //Space Complexity : O(1)


import java.util.ArrayList;

public class Solution
{
    public static int binarySearch(ArrayList<Integer> row,int mid){
        int l=0;
        int h=row.size()-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(row.get(m)<=mid){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        
        return l;
    }
    
    
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int n= matrix.size();
        int m =matrix.get(0).size();
        
        int low = 1, high = 100000;
        int desiredCount=(n * m ) / 2;
        while (low <= high) 
        {
            int mid = (high+low) / 2;
            int count = 0;
            
            for (int i = 0; i < n; i++) 
            {
                 count+=binarySearch(matrix.get(i),mid);
            }
            
            if (count <=desiredCount) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
            
        }     
        
        return low;
	}
}
