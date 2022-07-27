from collections import *

class Node:
    def __init__(self,val):
        self.val=val
        self.left=None
        self.right=None


def sortedArrayToBST(arr):
    if not arr:
        return None

    # find middle
    mid = (len(arr)) //2

    # make the middle element the root
    root = Node(arr[mid])

    # left subtree of root has all
    # values <arr[mid]
    root.left = sortedArrayToBST(arr[:mid])

    # right subtree of root has all
    # values >arr[mid]
    root.right = sortedArrayToBST(arr[mid + 1:])
    return root


def addallleftNodes(Node,stack):
    while Node is not None:
        stack.append(Node)
        Node=Node.left

def bstTOdll(root):
    stack=deque()
    addallleftNodes(root,stack)
    dummy=Node(-1)
    prev=dummy
    while len(stack) >0:
        curr=stack.pop()
        prev.right=curr
        curr.left=prev
        prev=curr
        addallleftNodes(curr.right,stack)
    head= dummy.right
    dummy.right=head.left=None
    head.left=prev
    prev.right=head
    return head

def display(node):
    head=node
    while node != None:
        print(node.val,end=" ")
        node=node.right
        if node==head:
            break



n=int(input())
lst=list(map(int, input().split()))
lst.sort()
head=None
root=sortedArrayToBST(lst)
head=bstTOdll(root)
display(head)

