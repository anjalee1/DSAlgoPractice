class Node:
   def __init__(self, data=None):
      self.data = data
      self.next = None
class SLinkedList:
   def __init__(self):
      self.head = None
      self.size=0
      self.tail=None

   def AddLast(self, newdata):
    #write your code here
    NewNode=Node(newdata)
    if self.size==0:
        self.head=NewNode
        self.tail=NewNode
    else:
        self.tail.next=NewNode
        self.tail=NewNode
    self.size=self.size+1

   def listprint(self):
      printval = self.head
      while printval is not None:
         print (printval.data)
         printval = printval.next

   def testList(self) :
        temp = self.head
        while temp is not None: 
            print(temp.data)
            temp = temp.next
    
        print(self.size)

        if  self.size > 0 :
            
            print(self.tail.data)
   

l1 = SLinkedList()
while 1>0 :
    str=input()

    if str[0]=='q':
     
        break;

    if str[0]=='a':
        
        val=int(str[-3]+str[-2])
        
        l1.AddLast(val)
        
        
l1.testList()
