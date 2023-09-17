class Solution {
    public void sortColors(int[] nums) {
        
        int n =nums.length;
        int lo=0;
        int mid=0;
        int hi=n-1;
        
        while(mid<=hi){
            switch(nums[mid]){
                case 0:{
                    swap(nums,lo,mid);
                    lo++;
                    mid++;
                    break;
                    
                }
                case 1:{ 
                    mid++;
                    break;
                    
                }
                case 2:{
                    swap(nums,mid,hi);
                    hi--;
                    break;
                    
                }
                    
                    
            }
        }
        
    }
    
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)

  //ide: https://leetcode.com/problems/sort-colors/description/
  //sol: https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=4
//https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
