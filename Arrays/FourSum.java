//ide: https://leetcode.com/problems/4sum/
//sol:https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23
//https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/

// Time Complexity: O(n³) 
// Reason: There are 2 nested loops and the front pointer as well as the right pointer (Third nested loop)

// Space Complexity: O(1), (Generally the space complexity that is used to return the answer is ignored)



class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0)
            return res;
        
        int n = nums.length;
    
        Arrays.sort(nums); 
    
        for (int i = 0; i < n; i++) {
        
            long target_3 = target - nums[i];
        
            for (int j = i + 1; j < n; j++) {
            
                long target_2 = target_3 - nums[j];
            
                int front = j + 1;
                int back = n - 1;
            
                while(front < back) {
                
                    int two_sum = nums[front] + nums[back];
                
                    if (two_sum < target_2) front++;
                
                    else if (two_sum > target_2) back--;
                
                    else {
                    
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                    
                        // Processing the duplicates of number 3
                        while (front < back && nums[front] == quad.get(2)) ++front;
                    
                        // Processing the duplicates of number 4
                        while (front < back && nums[back] == quad.get(3)) --back;
                
                    }
                }
                
                // Processing the duplicates of number 2
                while(j + 1 < n && nums[j + 1] == nums[j]) ++j;
            }
        
            // Processing the duplicates of number 1
            while (i + 1 < n && nums[i + 1] == nums[i]) ++i;
        
        }
        
    
        return res;
    }
}
