def fact(n):
    if n==1:
      return 1
    ft= n*fact(n-1)
    return ft
n= int(input())
f =fact(n)
print(f)
