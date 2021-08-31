def toh(n,t1id,t2id,t3id):
    if n==0:
        return
    toh(n-1,t1id,t3id,t2id)
    print(f"{n}[{t1id} -> {t2id}]")
    toh(n-1,t3id,t2id,t1id)
n=int(input())
t1id=int(input())
t2id=int(input())
t3id=int(input())
toh(n,t1id,t2id,t3id)

