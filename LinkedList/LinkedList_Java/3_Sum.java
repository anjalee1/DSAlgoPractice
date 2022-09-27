//video solution : https://www.youtube.com/watch?v=onLoX6Nhvmg&t=484s
//Time Complexity : O(N^2)
//Space Complexity : O(3*k)  // k is the no.of triplets
//ide: https://leetcode.com/problems/3sum/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
       Arrays.sort(nums);
       List<List<Integer>> res =new ArrayList<>();
       for(int i=0;i<nums.length-2;i++){
           if(i==0 || (i > 0 && nums[i] != nums[i - 1])){
               int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
               
               while (lo < hi) {
                   
                   if (nums[lo] + nums[hi] == sum) {
                       
                       ArrayList<Integer> temp =new ArrayList<>();
                       
                       temp.add(nums[i]);
                       temp.add(nums[lo]);
                       temp.add(nums[hi]);
                       res.add(temp);
                       
                       while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                       while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                       
                       lo++;
                       hi--;
                       
                       
                   }
                   
                   else if(nums[lo] + nums[hi]< sum){
                       lo++;
                   }
                   
                   else{
                       hi--;
                   }
                   
                   
                   
               }
               

           }
       }
        
        return res;
        
    }
}
