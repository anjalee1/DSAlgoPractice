class Solution {
    public int maxSubArray(int[] nums) {

        int sum =0;
        int maxi=nums[0];

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum>maxi) maxi=sum;
            if(sum<0) sum=0;
        }
        return maxi;
        
    }
}


//ide: https://leetcode.com/problems/maximum-subarray/description/
//sol: https://www.youtube.com/watch?v=w_KEocd__20&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=7

//tc: o(n)
//sc:o(1)
