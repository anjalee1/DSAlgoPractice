def height(root):
    #write your code here
    ht=-1
    for x in root.child:
        CH=height(x)
        ht=max(ht,CH)
    ht=ht+1
    return ht
