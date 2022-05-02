class Node:
     
    def __init__(self, key):
         
        self.key = key
        self.child = []
   
def newNode(key):   
    temp = Node(key)
    return temp
     
def constructor(lst,n):
    root = None
    stack = []
    for i in range(0,n):
        if lst[i]==-1:
            stack.pop()
        else:
            t= Node(lst[i])
            if len(stack) > 0:
                stack[-1].child.append(t)
                
            else:
                root=t
                
            stack.append(t)
    return root
  
def display(root):
    s= str(root.key)+"->"
    for x in root.child:
        s += str(x.key)+", "
    s += "." 
    print(s)
    for x in root.child:
        display(x)
    
def size(root):
  # write your code here
  s=0
  for x in root.child:
      xs=size(x)
      s=s+xs
  s=s+1
  return s
    
lst = []
n = int(input())
lst = list(map(int, input().split()))
root = constructor(lst,n)
# display(root)
print(size(root))
