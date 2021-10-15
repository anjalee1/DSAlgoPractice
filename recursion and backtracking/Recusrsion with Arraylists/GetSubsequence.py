def gss(st):
    if len(st)==0:
       blst=[]
       blst.append("")
       return blst
    ch =st[0]
    res=gss(st[1:])
    st1=[]
    for x in res:
        st1.append(x)
    for x in res:
        st1.append(ch+x)
    return st1
st=input()
translation={39:None}
a=gss(st)
print(str(a).translate(translation))
