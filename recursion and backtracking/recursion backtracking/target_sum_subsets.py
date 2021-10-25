import sys
sys.setrecursionlimit(10**6)
def printTargetSumSubsets(arr, idx, asf, sos, tar):
#write your code here

  if idx==len(arr):
        if sos==tar:
            print(asf+".")
        return
  printTargetSumSubsets(arr,idx+1,asf+str(arr[idx])+", ",sos+arr[idx],tar)
  printTargetSumSubsets(arr,idx+1,asf,sos,tar)






def main():
  n = int(input());
  arr = []
  for i in range(n) :
          arr.append(int(input()));

  tar = int(input());
  printTargetSumSubsets(arr,0,"",0,tar)
main()
