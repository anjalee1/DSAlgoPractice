def Increasing(n):
    if n ==0 :
        return
        
    Increasing(n-1)
    print(n)
        
n=int(input())
Increasing(n)
