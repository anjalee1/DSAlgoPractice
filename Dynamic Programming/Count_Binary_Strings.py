n=  int(input())
oldz=1
oldo=1
for i in range(2,n+1):
    newz=oldo
    newo=oldz+oldo
    oldz=newz
    oldo=newo
print(oldz+oldo)
