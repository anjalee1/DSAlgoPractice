
def twoTransactions(arr, n):
#write your code here
  mpist=0
  leastsf=arr[0]
  dpl=[0]*len(arr)
  for i in range(1,len(arr)):
      if arr[i]<leastsf:
          leastsf=arr[i]
      mpist=arr[i]-leastsf
      if mpist>dpl[i-1]:
          dpl[i]=mpist
      else:
        dpl[i]=dpl[i-1]
        
  mpibt=0
  maxat=arr[len(arr)-1]
  dpr=[0]*len(arr)
  for i in range(len(arr)-2,0,-1):
      if arr[i]>maxat:
          maxat=arr[i]
      mpibt=maxat-arr[i]
      if mpibt>dpr[i+1]:
          dpr[i]=mpibt
      else:
          dpr[i]=dpr[i+1]
  
  op=0
  for i in range(0,len(arr)):
    if dpl[i]+dpr[i]>op:
        op=dpl[i]+dpr[i]
  print(op)


def main():
  n = int(input())
  array = []
  for i in range(n) :
     array.append(int(input()))

  twoTransactions(array, n)
  
if __name__ == '__main__':
    main()
