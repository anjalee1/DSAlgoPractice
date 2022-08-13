class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        count = 0
        dp = [[False for col in range(n)] for row in range(n)]

        for gap in range(0, n):
            si = 0
            e = gap
            while e < n:
                if gap == 0:
                    dp[si][e] = True
                elif gap == 1:
                    if s[si] == s[e]:
                        dp[si][e] = True
                    else:
                        dp[si][e] = False
                else:
                    if s[si] == s[e]:
                            dp[si][e] =dp[si + 1][e - 1]
                    else:
                           dp[si][e] = False    
                if dp[si][e]:
                    count=count+1
               
                        
                si = si + 1
                e = e + 1

        return count
        
        #ide: https://leetcode.com/problems/palindromic-substrings/submissions/
        #solutionvideo=https://www.youtube.com/watch?v=XmSOWnL6T_I
        #tc=o(n^2)
        #sc=o(n^2)





