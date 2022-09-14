class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--)
            stack.push(nums[i]);
        for(int i=n-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=nums[i])
                stack.pop();

            if(stack.empty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            
            stack.push(nums[i]);
        }
        
        return result;
    }
}
