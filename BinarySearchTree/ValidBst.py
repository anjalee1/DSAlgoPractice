
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import math
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        ans= validBST(root,-math.inf,math.inf)
        return ans        
      
def validBST(root,minm,maxm):
        if root ==None:
            return True
        if root.val < minm or root.val >maxm:
            return False
        return validBST(root.left,minm,root.val-1) and validBST(root.right,root.val+1,maxm)
        
