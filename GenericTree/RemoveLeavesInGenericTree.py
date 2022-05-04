def removeLeaves(root):
    # write code here
    for child in reversed(root.children):
      if len(child.children)==0:
        root.children.remove(child)
    for child in (root.children):
         removeLeaves(child)
