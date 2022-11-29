class Solution {
    public boolean wordBreak(String s, List<String> c) {
        
        int[] dp = new int[s.length()];
        
        for(int i=0; i<dp.length;i++){
            
            for(int j=0; j<=i;j++){
                
                String wCheck =s.substring(j,i+1);
                if(c.contains(wCheck)){
                    if(j>0){
                      dp[i] += dp[j-1]; 
                    }
                    else{
                        dp[i]+=1;
                    }
                    
                }
                
            }
        }
        
        return dp[s.length()-1] >0;
        
        
        
    }
}

//ide:https://leetcode.com/problems/word-break/
//sol:https://www.youtube.com/watch?v=2NaaM_z_Jig&t=111s

//tc:o(n^2)
//sc:o(n)
