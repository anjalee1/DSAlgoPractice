
//ide:https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
//sol:https://www.youtube.com/watch?v=IV9pbZsi5cc&t=3s

//tc:o(n)
//sc:o(1)

class Solution
{
    public long fun(String s)
    {
        long a=0;
        long ab=0;
        long abc=0;
        
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            
            if(ch=='a'){
                a=(2*a+1)% 1000000007;
            }
            else if(ch=='b'){
                 ab=(2*ab+a)% 1000000007;
                
            }
            else if(ch=='c'){
                abc=(2*abc+ab)% 1000000007;
            }
            
        }
        
        return abc;
      
    }
}
