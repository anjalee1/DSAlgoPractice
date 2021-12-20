
n=int(input())

vals=input().split()
wts=input().split()
v=[]
w =[]
for x in vals:
    v.append(int(x))

for y in wts:
    w.append(int(y))
    
cap=int(input())    
dp=[0]*(cap+1)
dp[0]=0


for bagc in range(1,cap+1):
    maxm=0
    for i in range(n):
        if w[i]<=bagc:
            rbagc=bagc-w[i]
            rbagv=dp[rbagc]
            tbagv=rbagv+v[i]
            if tbagv>maxm:
                maxm=tbagv
    dp[bagc]=maxm
print(dp[cap])
