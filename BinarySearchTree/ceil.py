https://www.codingninjas.com/codestudio/problems/920464?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
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
