
#https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
#Approach 1
def tnf(root,lst):
    if root is None:
        return
    tnf(root.left,lst)
    lst.append(root.data)
    tnf(root.right,lst)

    
class Solution:
    # root : the root Node of the given BST
    # target : the target sum
    def isPairPresent(self,root, target): 
        lst=list()
        tnf(root,lst)
        li=0
        ri=len(lst)-1
        
        while li<ri:
            left=lst[li]
            right=lst[ri]
            if(left+right<target):
                li=li+1
            elif(left+right>target):
                ri=ri-1
            
            else:
                return 1
        return 0
tc= o(n)
sc=o(n)      
      
#Approach 2
