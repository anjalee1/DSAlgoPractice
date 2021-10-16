def PrintDecInc(n):
   if n==0:
       return
   print(n)
   PrintDecInc(n-1)
   print(n)
n=int(input())
PrintDecInc(n)
