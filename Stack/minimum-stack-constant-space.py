class MinStack:
       
    def __init__(self):
        self.data = [ ];
        self.minVal = 0
       
    def size(self):
        # write your code here
       return len(self.data)

    def push(self , val):
        # write your code here
        if self.size()==0:
            self.data.append(val)
            self.minVal=val
        elif val<self.minVal:
            self.data.append(val+val-self.minVal) 
            self.minVal=val  
        else:
            self.data.append(val)

       
    def top(self):
        # write your code here
        if self.size()==0:
            print("Stack underflow") 
            return -1
        elif self.data[-1]<self.minVal:
            return self.minVal
        else:
            return self.data[-1]    
   
    def pop(self):
        # write your code here
        if self.size()==0:
            print("Stack underflow") 
            return -1
        elif self.data[-1]<self.minVal:
            val=self.minVal
            fv=self.data.pop()
            self.minVal=2*val-fv
            return val
        else:
            return self.data.pop()  
           
       
    def minimum(self):
        # write your code here
        if self.size()==0:
            print("Stack underflow")
            return -1
        else:
            return self.minVal


def main():
   
   
    inpStr = str(input()).strip().split(" ")
    st = MinStack()
   
    while inpStr[0] != "quit":
        if inpStr[0].strip() == "push":
            val = inpStr[1]
            st.push(int(val))
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
        elif inpStr[0].strip() == "min":
            val = st.minimum()
            if val != -1:
                print(val)
           
        inpStr = str(input()).strip().split(" ")
   
   
main()
