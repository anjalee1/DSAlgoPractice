class Solution:
    
    #Function to find minimum number of pages.
    
    def isPossible(self,arr,mid,noOfStudents):
        st=1
        sum=0
        for x in arr:
            sum += x
            if sum>mid:
                st+=1
                sum=x
        return st<=noOfStudents
                
            
        
    def findPages(self,A, N, M):
        #code here
        lo=max(A)
        hi=sum(A)
        while lo<=hi:
            mid=(hi-lo)//2 + lo
            if self.isPossible(A,mid,M)==True:
                ans=mid
                hi=mid-1
            else:
                lo=mid+1
        return ans


#{ 
#  Driver Code Starts
#Initial Template for Python 3

#contributed by RavinderSinghPB
if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        
        n=int(input())
        
        arr=[int(x) for x in input().strip().split()]
        m=int(input())
        
        ob=Solution()
        
        print(ob.findPages(arr,n,m))
# } Driver Code Ends

#tc=n*log(sum(arr))
#Note: exact same approach can be used for painter's problem
