
string=input()
a=0
ab=0
abc=0
for i in range(len(string)):
    cr=string[i]
    if cr=="a":
        a=(2*a)+1
    elif cr=="b":
        ab=(2*ab)+a
    elif cr=="c":
        abc=(2*abc)+ab
print(abc)
