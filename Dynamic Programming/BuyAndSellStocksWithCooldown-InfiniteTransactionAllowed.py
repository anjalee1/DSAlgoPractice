
n=int(input())
stocks=[]

for i in range(n):
    stocks.append(int(input()))

obsp=-stocks[0]
ossp=0
ocsp=0
for i in range(1,n):
    nbsp=0
    nssp=0
    ncsp=0
    if ocsp-stocks[i]>obsp:
        nbsp=ocsp-stocks[i]
    else:
        nbsp=obsp
    if obsp+stocks[i]>ossp:
        nssp=obsp+stocks[i]
    else:
        nssp=ossp
    if ossp>ocsp:
        ncsp=ossp
    else:
        ncsp=ocsp
        
    obsp=nbsp
    ossp=nssp
    ocsp=ncsp
print(ossp)
