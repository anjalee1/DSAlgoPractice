
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> st= new Stack<Integer>();
        for(int i=0;i<n;i++){
            st.push(i);
        } 
        while(st.size()>1){
            int i=st.pop();
            int j=st.pop();
            if(Runner.knows(i,j)){
                st.push(j);
            }
            else{
                st.push(i);
            }
        } 
        if(st.empty())
            return -1;
        int pot=st.pop();
        for(int i=0;i<n;i++){
            if(i!=pot){
                if(Runner.knows(i,pot)==false || Runner.knows(pot,i)==true){
                    return -1;
                }
            }
         }
        return pot; 
    }
}

//solution video:nsoluhttps://www.youtube.com/watch?v=CiiXBvrX-5A&t=7s
//ide: https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
//tc:o(N)
//sc:o(N)
