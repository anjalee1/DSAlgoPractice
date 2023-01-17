//method -1  binary serach : tc : nlogn  sc =o(1)

class Solution {
    public int missingNumber(int[] nums) {
       Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left + right)/2;
            if(nums[mid]>mid) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}

//method-2  xor  tc:o(n) sc:o(1)

a number XOR itself will become 0, any number XOR with 0 will stay unchanged. 
  So if every number from 1...n XOR with itself except the missing number, 
the result will be the missing number.

class Solution {
    public int missingNumber(int[] nums) {
      int res = nums.length;
      for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

//method -3  sum   tc: o(n)  sc: o(1)

class Solution {
    public int missingNumber(int[] nums) {
       int sum = 0;
       for(int i = 0; i < nums.length; i++){
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }
}
