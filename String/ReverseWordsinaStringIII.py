lass Solution:
    def reverseWords(self, s):
        ans=''
        temp=''
        for i in range(len(s)-1,-1,-1):
            if s[i]==' ':
                ans=' '+temp+ans
                temp=''
            else:
                temp=temp+s[i]   
            if i==0:
                ans=temp+ans     
            
        return ans
    
    #tc=o(n)
    #sc=o(1) => because python uses string interning
