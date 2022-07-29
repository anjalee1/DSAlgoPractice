
'''
    Following is the TreeNode class structure

    class TreeNode:
        def __init__(self, data):
            self.data = data
            self.left = None
            self.right = None
'''

def findCeil(root, x):
    ans= - 1
    if root is None:
        return -1
    while root:
        if root.data==x:
            return root.data
        elif root.data<x:
            root=root.right
        else:
            ans=root.data
            root=root.left
    return ans
