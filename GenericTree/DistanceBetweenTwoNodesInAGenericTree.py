def distanceBetweenNodes(root, data1, data2):
    
    l1=nodeToRootPath(root,data1)
    l2=nodeToRootPath(root,data2)
    i=len(l1)-1
    j=len(l2)-1
    while i>=0 and j>=0 and l1[i]==l2[j]:
        i=i-1
        j=j-1
    i=i+1
    j=j+1
    return i+j
