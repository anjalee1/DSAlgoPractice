class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n =nums.length;
      int[] nge= new int[n];
      int[] ans =new int[n-k+1];
      nge[n-1]=n;
      Stack<Integer> st=new Stack<Integer>();
      st.push(n-1);
      for(int i=n-2;i>=0;i--){
          while(st.size()>0 && nums[st.peek()]<=nums[i]){
              st.pop();
              
          }
          nge[i]=st.empty()?n:st.peek();
          st.push(i);
              
      }
        
      int j=0;
      for(int i=0;i<=n-k;i++){
         if(j<i){
             j=i;
         }
         
         while(nge[j]<i+k){
             j=nge[j];
         }
          ans[i]=nums[j];
          
         
          
         
      }
      return ans;
    }
}

//ans video:https://www.youtube.com/watch?v=tCVOQX3lWeI
//leetcodelink:https://leetcode.com/problems/sliding-window-maximum/submissions/
