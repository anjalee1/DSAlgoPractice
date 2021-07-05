
def print_decrease(n):
  
  
  if n==0:
    return
  print(n)
  print_decrease(n-1)
n= int(input())
print_decrease(n)
