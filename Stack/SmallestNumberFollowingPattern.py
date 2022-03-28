
from collections import deque
def main():
    inp = str(input())
    stack=deque()

    # write your code here
    num=1
    for char in inp:
        if char=='d':
            stack.append(num)
            num=num+1

        else:
            stack.append(num)
            num=num+1

            while len(stack)>0:
                print(stack.pop(),end='')
                
    stack.append(num)

    while len(stack)>0:
            print(stack.pop(),end='')
    
        
        
main()
