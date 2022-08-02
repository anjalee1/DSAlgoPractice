# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.idx=1
        self.ans=-1
        
        def solve(root,k):
            if root is None:
                return
            solve(root.left,k)
            if k==self.idx:
                self.ans =root.val
                self.idx=self.idx+1
                return
            else:
                self.idx=self.idx+1
            solve(root.right,k)

        solve(root,k)
        return self.ans
