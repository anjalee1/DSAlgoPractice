
import sys
n=int(input())
prices=[]
for i in range(n):
    prices.append(int(input()))
bd=0
sd=0
profit=0
for i in range(1,len(prices)):
    if prices[i]>prices[i-1]:
        sd +=1
    else:
        profit += prices[sd]-prices[bd]
        bd=sd=i
profit += prices[sd]-prices[bd]
print(profit)
