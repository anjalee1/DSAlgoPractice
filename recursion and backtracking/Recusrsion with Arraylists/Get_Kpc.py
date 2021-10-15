
d= {'0':'.;','1': 'abc','2':'def','3':'ghi','4':'jkl','5':'mno','6':'pqrs','7':'tu','8':'vwx','9':'yz'}
def KPC(string):
    if len(string)==0:
        lst=[""]
        return lst
    ch =string[0]
    res=KPC(string[1:])
    mres=[]
    code=d[ch]
    for i in range(0,len(code)):
        chcode= code[i]
        for x in res:
            mres.append(chcode+x)
    
    return mres
    
string=input()
trans={39:None}
a=KPC(string)
print(str(a).translate(trans))
