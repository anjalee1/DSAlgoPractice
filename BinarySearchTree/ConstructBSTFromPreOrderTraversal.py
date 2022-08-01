
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        l=1
        r=1000
        self.idx=0
        def bstFromPreorderUtil(preorder,lt,rt):
            if self.idx >=len(preorder) or preorder[self.idx]<lt or preorder[self.idx]>rt:
                return None
            node= TreeNode(preorder[self.idx])
            self.idx=self.idx+1
            node.left= bstFromPreorderUtil(preorder,lt,node.val)
            node.right= bstFromPreorderUtil(preorder,node.val,rt)
            return node
        return bstFromPreorderUtil(preorder,l,r)
