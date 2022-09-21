//https://www.youtube.com/watch?v=fdnvPurbs9Y
//https://practice.geeksforgeeks.org/contest/interview-series-68/problems/#



class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
       Stack<Pair> st = new Stack<>();
       for(int i=0;i<N;i++){
           Pair p=new Pair(color[i],radius[i]);
           boolean matched=false;
           if(!st.empty() && st.peek().color==p.color && st.peek().radius==p.radius){
               matched=true;
               st.pop();
           }
           
           if(!matched){
               st.push(p);
           }
       }
       
       return st.size();
    }
}
        
class Pair{
    int color;
    int radius;
    Pair(int col,int rad){
        color=col;
        radius=rad;
        
    }
}
