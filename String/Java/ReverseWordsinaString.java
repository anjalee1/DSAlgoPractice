class Solution {
    public String reverseWords(String s) {
        
        int end =s.length();
        String ans ="";
        String temp="";
        int left =0;
        int right=s.length()-1;
        while(left<s.length() && s.charAt(left)==' ' ){
            left=left+1; 
        }
     
        while(right>0 && s.charAt(right)==' '){
           right =right-1; 
        }
        for(int i =left;i<right+1;i++){
            
            if(s.charAt(i)==' ' && s.charAt(i-1)!=' '){
                
                ans=" "+temp+ans;
                temp="";
                
            }
            else if(s.charAt(i)!=' '){
               temp=temp+s.charAt(i); 
            }
            
            if(i==right){
                ans =temp+ans;
            }
            
        }
        
        return ans;
        
    }
}

//ide:https://leetcode.com/problems/reverse-words-in-a-string/
//sol:ANJALI

//TC: O(N)
//SC:O(1)
