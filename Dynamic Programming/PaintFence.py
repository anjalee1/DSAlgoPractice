n=int(input())
k=int(input())
same=k
diff=k*(k-1)
total=same + diff
for i in range(3,n+1):
    same=diff*1
    diff=total*(k-1)
    total=same+diff
print(total)
