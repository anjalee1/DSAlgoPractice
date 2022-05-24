from collections import defaultdict

def smallestSubstring(str1,str2):
    dstr2 = defaultdict(int)
    ans=""
    for ch in str2:
      dstr2[ch]=dstr2[ch]+1

	
    mc=0
    dmc=len(str2)
    dstr1=defaultdict(int)
    i=-1
    j=-1


    while True:
        f1=False
        f2=False
        #acquire
        while i <len(str1)-1 and mc <dmc:
            i=i+1
            dstr1[str1[i]]=dstr1[str1[i]]+1
            if dstr1[str1[i]] <= dstr2[str1[i]]:
                mc=mc+1
            f1=True
        
        #collect and release
        while j<i and mc==dmc:
            pans=str1[j+1:i+1]
            if len(ans)==0 or len(pans)<len(ans):
                ans=pans
            j=j+1
            if dstr1[str1[j]]==1:
                del dstr1[str1[j]]
            else:
                dstr1[str1[j]]=dstr1[str1[j]]-1
            
            if dstr1[str1[j]]<dstr2[str1[j]]:
                mc=mc-1
            f2=True

        if f1==False and f1==False:
            break
    
    return ans


str1=input()
str2=input()
print(smallestSubstring(str1.strip(),str2.strip()))
