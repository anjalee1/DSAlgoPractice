def pow(x,n):
    if n==0:
        return 1
    elif n<0:
        return 1/pow(x,n)
    else:
        if n%2 ==0:
            return pow(x,n/2)*pow(x,n/2)
        else:
            return pow(x,(n-1)/2)*pow(x,(n-1)/2)*x
x=int(input())
n=int(input())
print(pow(x,n))
