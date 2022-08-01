# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root: Optional[TreeNode]) -> str:
        st=[]
        serializeutil(root,st)
        return ",".join(st)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        arr=data.split(",")
        return deserializeutil(arr)

def serializeutil(root,st):
    if root ==None:
        st.append("None")
        return 
    st.append(str(root.val))
    serializeutil(root.left,st)
    serializeutil(root.right,st)

    
    
idx=0
def deserializeutil(arr):
    global idx
    if idx>=len(arr) or arr[idx]=="None":
        idx=idx+1
        return None
    node=TreeNode(int(arr[idx]))
    idx=idx+1
    node.left =deserializeutil(arr)
    node.right=deserializeutil(arr)
    return node
        

# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans
