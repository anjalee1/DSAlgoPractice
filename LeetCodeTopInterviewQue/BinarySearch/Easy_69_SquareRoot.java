//ide: https://leetcode.com/problems/sqrtx/
//tc:o(logn)
//sc:o(1)


class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int low,high;
        if(x>0 && x<1) {
            low=x;
            high=1;
        }
        else{
            low=1;
            high=x;
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(x / mid== mid){
                return mid;
               
            }
            else if(x/mid>mid){
                 ans =mid;
                 low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}
