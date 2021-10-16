def Decreasing(n):
    if n==0:
        return
    print(n)
    Decreasing(n-1)
    
n= int(input())
Decreasing(n)
