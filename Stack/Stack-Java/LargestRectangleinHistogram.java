//ide:https://leetcode.com/problems/largest-rectangle-in-histogram/description/
//sol:https://www.youtube.com/watch?v=0do2734xhnU&t=2s

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] widths=new int[heights.length];
        widths[heights.length-1]=heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(heights.length-1);
        for (int i=heights.length-2;i>=0;i--){
            while(st.size()>0 && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            widths[i]=st.empty()?heights.length:st.peek();
            st.push(i);
        }
        
        while(st.size()>0){
                st.pop();
        }
       
        widths[0]=widths[0]-(-1)-1;
        st = new Stack<>();
        st.push(0);
         System.out.println(st.peek());
        for (int i=1;i<heights.length;i++){
            while(st.size()>0 && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            widths[i]=st.empty()?(widths[i]-(-1))-1:(widths[i]-st.peek())-1;
            st.push(i);
        }
        
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area=heights[i]*widths[i];
            
            if(area>maxArea){
                maxArea=area;
             }
        }
        return maxArea;
        
    }
}
