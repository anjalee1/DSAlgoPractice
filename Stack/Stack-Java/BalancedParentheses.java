class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='{' || ch =='['|| ch =='('){
                st.push(s.charAt(i));
              }
            else if(st.empty()) return false;
            else if(ch == ')' && st.pop() != '(') return false;
            else if(ch == ']' && st.pop() != '[') return false;
            else if(ch == '}' && st.pop() != '{') return false;
        }
        return st.empty();
        }
        
    }
