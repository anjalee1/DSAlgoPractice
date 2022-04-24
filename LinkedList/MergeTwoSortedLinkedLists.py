def mergeTwoSortedLists(self,l1, l2):
       #rite your code here
       mergedList=LinkedList()
       one=l1.head
       two=l2.head
       while one != None and two != None:
           if one.data<two.data:
               mergedList.addLast(one.data)
               one =one.next
           else:
              mergedList.addLast(two.data)
              two=two.next

       while one != None:
           mergedList.addLast(one.data)
           one =one.next

       while two != None:
          mergedList.addLast(two.data)
          two=two.next

       return mergedList
