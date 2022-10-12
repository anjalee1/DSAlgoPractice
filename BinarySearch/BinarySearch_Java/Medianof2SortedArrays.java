

//ide: https://leetcode.com/problems/median-of-two-sorted-arrays/
//sol: https://www.youtube.com/watch?v=NTop3VTjmxk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=66

// Time Complexity : O(log(min(m,n)))
// Reason – We are applying binary search on the array which has a minimum size.
// Space Complexity: O(1)
// Reason – No extra array is used.
  
  
  
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length;
        int n= nums2.length;
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        
        int low=0,high=m,medianPos=((m+n)+1)/2;
        
        while(low<=high){
            
            int cut1 = (low+high)/1;
            int cut2 = medianPos - cut1;
            
            int l1 = (cut1 == 0)? Integer.MIN_VALUE:nums1[cut1-1];
            int l2 = (cut2 == 0)? Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = (cut1 == m)? Integer.MAX_VALUE:nums1[cut1];
            int r2 = (cut2 == n)? Integer.MAX_VALUE:nums2[cut2];
            
           if(l1<=r2 && l2<=r1) {
            if((m+n)%2 != 0)
                return Math.max(l1,l2);
            else 
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
          }
          else if(l1>r2) high = cut1-1;
          else low = cut1+1;

        }
        
        return 0.0;
        
        
        
    }
}

//method 2
//Time Complexity : O(m+n)
// Reason – We are still traversing both the arrays linearly.
// Space Complexity: O(1)
// Reason – We do not use any extra array.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m =nums1.length;
        int n= nums2.length;
        int len=m+n;
        
        int count=0;
        int prev =0;
        int curr =0;
        
        int i=0;
        int j=0;
        
        while(count++ <= len/2 ){
            prev =curr;
            
             if(i>= nums1.length) {     // if aIndex >= a length then only use b;
                curr= nums2[j++];   // update current value and increment bIndex;
                continue;                
            } 
            
            if(j >= nums2.length ) {    // similar as above,for bIndex
                curr = nums1[i++];
                continue;
            } 
            
            if(nums1[i]<nums2[j]){
                curr=nums1[i++];
            }
            
            else{
                curr=nums2[j++];
            }
        }
        
        
        
        if(len%2==0){
            return (double)(prev+curr)/2;     
        }
            
        else{
            
            return (double) curr;
        }
    }
}
