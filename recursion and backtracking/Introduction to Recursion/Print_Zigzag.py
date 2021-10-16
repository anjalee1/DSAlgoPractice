def pzz(n):
    if n==0:
        return
    print(n,"",end ='')
    pzz(n-1)
    print(n,"",end ='')
    pzz(n-1)
    print(n,"",end ='')


n= int(input())
pzz(n)
