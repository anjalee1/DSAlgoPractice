class CustomStack:
       
    def __init__(self , cap):
        self.cap = cap
        self.tos = -1
        self.arr = []
        self.arr = [0] * cap
       
    def size(self):
        return self.tos+1
        
       
    def push(self , data):
        # write your code here
        if self.tos == self.cap - 1:
            narr = [0] * (self.cap * 2)
            for i in range(self.cap):
                narr[i] = self.arr[i]
            self.arr = narr
            self.cap = 2 * self.cap
           
       
        self.tos = self.tos + 1
        self.arr[self.tos] = data
   
       
    def top(self):
        # write ur code here
       
       if self.tos==-1:
          print("Stack underflow")
          return -1
       else:
           return self.arr[self.tos]
   
    def pop(self):
        # write ur code here
        if self.tos==-1:
          print("Stack underflow")
          return -1
        else:
            rv=self.arr[self.tos]
            self.tos=self.tos-1
            return rv
       
    def display(self):
        # write ur code here
        i=self.tos
        while i>=0:
            print(self.arr[i].strip(),end=' ')
            i=i-1
        print()
        
def main():
   
    n = int(input());
   
    inpStr = str(input()).split(" ")
    st = CustomStack(n)
   
    while inpStr[0] != "quit":
        if inpStr[0].strip() == "push":
            val = inpStr[1]
            st.push(val)
        elif inpStr[0].strip() == "pop":
            val = st.pop()
            if val != -1:
                print(val)
        elif inpStr[0].strip() == "top":
            val = st.top()
            if val != -1:
                print(val)
        elif inpStr[0].strip() == "size":
            print(st.size())
        elif inpStr[0].strip() == "display":
            st.display()
           
        inpStr = str(input()).split(" ")
           
   
   
   
main()
