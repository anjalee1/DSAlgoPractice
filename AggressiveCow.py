def ispossible(stalls,k,mid):
    cowCount=1
    lastpos=stalls[0]
    for i in range(0,len(stalls)):
        if stalls[i] - lastpos>=mid:
            cowCount=cowCount+1
            if cowCount==k:
                return True
            lastpos=stalls[i]
    return False
def aggressiveCows(stalls, k):
    # Write your code here.
    stalls.sort()
    lo=0
    hi=stalls[len(stalls)-1]
    while lo<=hi:
        mid = ((hi-lo)//2)+lo
        if ispossible(stalls,k,mid)==True:
            ans=mid
            lo=mid+1
        else:
           hi=mid-1
    return ans
   
