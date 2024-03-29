https://www.codingninjas.com/codestudio/problems/920457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

    Following is the TreeNode class structure

    class TreeNode:

        def __init__ (self, data):

            self.data = data
            self.left = None
            self.right = None
            
''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

import sys
def floorInBST(root, X):
    ans=sys.maxsize
    if root is None:
        return -1
    while root:
        if root.data==X:
            return root.data
        elif root.data>X:
            root=root.left
        else:
            ans=root.data
            root=root.right
    return ans

   
