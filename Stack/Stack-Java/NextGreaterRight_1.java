class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> mp=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.size()==0){
                mp.put(nums2[i],-1);
                
            }
            else{
                mp.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
            
            
        }
        
        for (int i = 0; i < nums1.length; i++){
            nums1[i] = mp.get(nums1[i]);
        }
        return nums1;
    }
}

//tc:o(n)
//video_explanation:https://www.youtube.com/watch?time_continue=949&v=rSf9vPtKcmI
//code found: https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
//leetcode link: https://leetcode.com/problems/next-greater-element-i/

//note : next smaller left and right ,next greater left : all uses same logic ..just for the left run the first for loop in order and for right run the loop from behind
