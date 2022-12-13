
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; 
        if(i >= 0) {                           
            int j = nums.length - 1;              
            while(nums[j] <= nums[i]) j--;      
            swap(nums, i, j);                     
        }
        reverse(nums, i + 1, nums.length - 1);      
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}

// Time Complexity: For the first iteration backward, the second interaction backward and reversal at the end takes O(N) for each,
// where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(N).

// Space Complexity: Since no extra storage is required. Thus, its complexity is O(1).

//ide: https://leetcode.com/problems/next-permutation/description/
//sol:https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=17
//https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
