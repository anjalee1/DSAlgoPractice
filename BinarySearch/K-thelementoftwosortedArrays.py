import sys

class Solution:
    def kthElement(self,  arr1, arr2, n, m, k):
        
        if n>m:
            return self.kthElement(arr2, arr1, m, n, k)

        lo=max(0,k-m)
        hi=min(k,n)
        while lo<=hi:
            cut1=(hi-lo)//2 +lo
            cut2=k-cut1
            l1= -sys.maxsize - 1 if cut1==0 else arr1[cut1-1]
            l2= -sys.maxsize - 1 if cut2==0 else arr2[cut2-1]
            r1=sys.maxsize if cut1==n else arr1[cut1]
            r2=sys.maxsize if cut2==m else arr2[cut2]
            if l1 <= r2 and l2<=r1:
                return max(l1,l2)
            elif(l1>r2):
                hi=cut1-1
            else:
                lo=cut1+1
