def getMazePaths(sr,sc,dr,dc):
    if sr==dr and sc==dc:
        lst=[""]
        return lst
    paths =[]
    for s in range(1,dc-sc+1):
        hpaths=getMazePaths(sr,sc+s,dr,dc)
        for x in hpaths:
            paths.append("h"+str(s)+str(x))
    
    for s in range(1,dr-sr+1):
        vpaths=getMazePaths(sr+s,sc,dr,dc)
        for x in vpaths:
            paths.append("v"+str(s)+str(x))
            
    for s in range(1,(dr-sr+1 and dc-sc+1)):
        dpaths=getMazePaths(sr+s,sc+s,dr,dc)
        for x in dpaths:
            paths.append("d"+str(s)+str(x))
    return paths
n=int(input())
m=int(input())
a=getMazePaths(1,1,n,m)
trans={39:None}
print(str(a).translate(trans))
