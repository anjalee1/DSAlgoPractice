//ide : https://leetcode.com/problems/longest-valid-parentheses/
//sol: https://leetcode.com/problems/longest-valid-parentheses/solutions/127609/longest-valid-parentheses/?orderBy=most_votes

//tc: o(n)
//sc:o(n)

class Solution {
    public int longestValidParentheses(String s) {
        if(s=="") return 0;
        int maxLen =0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);

            if(ch=='(') st.push(i);

            else{
                st.pop();
                if(st.empty()) 
                   st.push(i);
                else{
                    maxLen=Math.max(maxLen,i-st.peek());
                 }
            }
               
        }
        return maxLen;
    }
}
