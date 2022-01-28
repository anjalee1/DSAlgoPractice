
import sys
n=int(input())
prices=[]
for i in range(n):
    prices.append(int(input()))
lsf=sys.maxsize
pist=0
op=0
for i in range(len(prices)):
    if prices[i]<lsf:
        lsf=prices[i]
    pist=prices[i]-lsf
    if pist>op:
        op=pist
print(op)
