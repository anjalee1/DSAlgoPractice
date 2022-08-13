
class Solution:
    def longestPalindrome(self, s: str) -> str:
            n = len(s)
            string= ""
            length=0
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
                    if dp[si][e] and length<gap+1:
                        length=gap+1
                        string=s[si:e+1]

                    si = si + 1
                    e = e + 1

            return string
          
          #tc=o(n^2)
          #sc=o(n^2)
          #solutionvideo=https://www.youtube.com/watch?v=WpYHNHofwjc
          #ide=https://leetcode.com/problems/longest-palindromic-substring/submissions/
