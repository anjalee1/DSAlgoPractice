def maximum(root):
    #write your code here
    maxm=-math.inf
    for x in root.child:
        cm=maximum(x)
        maxm=max(maxm,cm)
    maxm=max(maxm,root.key)
    return maxm
