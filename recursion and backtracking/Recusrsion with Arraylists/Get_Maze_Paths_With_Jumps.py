def getMazePaths(sr,sc,dr,dc):
    if sr==dr and sc==dc:
        lst=[""]
        return lst
    hpath=[]
    vpath=[]
    if sc<dc:
        hpath=getMazePaths(sr, sc+1,dr, dc)
    if sr<dr:
        vpath=getMazePaths(sr+1,sc,dr,dc)
    paths =[]
    
    for x in hpath:
        paths.append("h"+str(x))
    for x in vpath:
        paths.append("v"+str(x))
    return paths
n=int(input())
m=int(input())
a=getMazePaths(1,1,n,m)
trans={39:None}
print(str(a).translate(trans))
