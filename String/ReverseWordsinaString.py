
class Solution:
    def reverseWords(self, s: str) -> str:
        end = len(s) - 1
        ans = ""    
        left=0
        while left <len(s) and s[left]==' ':
            left=left+1
        right=len(s)-1
        while right >0 and s[right]==' ':
            right=right-1
        temp=''
        for i in range(left,right+1):
            if s[i]==' ' and s[i-1] !=' ':
                ans=" "+temp+ans
                temp=''
            elif s[i]!=' ':
                temp=temp+s[i]
            if i==right:
                ans=temp+ans  
                            
        return ans
