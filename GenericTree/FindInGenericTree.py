def find(root, data):
    
    # Write your code here
    if root.data==data:
        return True
    for child in root.children:
        fc=find(child,data)
        if fc:
            return True
    return False
    
