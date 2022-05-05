def nodeToRootPath(root,val):
    if root.data==val:
        li=[]
        li.append(root.data)
        return li

    for child in root.children:
        childLi=nodeToRootPath(child,val)
        if len(childLi)>0:
            childLi.append(root.data)
            return childLi
    return []
