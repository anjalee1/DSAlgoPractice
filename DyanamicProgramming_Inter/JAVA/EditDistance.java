//ide: https://leetcode.com/problems/edit-distance/
//sol:https://www.youtube.com/watch?v=tooMn-xfYCU&t=1266s

// Time Complexity: O(N*M)
// Reason: There are two nested loops
// Space Complexity: O(N*M)
// Reason: We are using an external array of size ‘N*M’. Stack Space is eliminated.



class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] dp= new int[word1.length()+1][word2.length()+1];
        
        for(int i =0;i< dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                
                if(i==0){
                    dp[i][j] =j;
                }
                
                else if(j==0){
                    dp[i][j] =i;
                    
                }
                else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else{
                        int f1 = 1+dp[i-1][j-1];
                        int f2 = 1+dp[i-1][j];
                        int f3 = 1+dp[i][j-1];
                        dp[i][j]=Math.min(f3,Math.min(f1,f2));
                    }
                }
                
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
            
        
    }
}
