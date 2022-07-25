
import sys

def eggDrop(eggs,floors):
    dp=[[0 for col in range (floors+1)]for row in range(eggs+1)]
    for e in range(1,eggs+1):
        for f in range(1,floors+1):
            if e==1:
                dp[e][f]=f

            elif f==1:
                dp[e][f]=1
            
            else:
                minm=sys.maxsize
                mrf=f-1
                prf=0
                while mrf>=0:
                   val1=dp[e][mrf]
                   val2=dp[e-1][prf]
                   maxv=max(val1,val2)
                   minm=min(maxv,minm)
                   mrf=mrf-1
                   prf=prf+1
                dp[e][f]=minm+1
    return dp[eggs][floors]


def main():
    eggs= int(input())
    floors=int(input())
    print(eggDrop(eggs,floors))

if __name__ == "__main__":
    main()
