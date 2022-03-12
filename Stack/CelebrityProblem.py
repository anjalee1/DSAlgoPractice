def findCelebrity(arr):
    st = []
    for i in range(len(arr)):
        st.append(i)
        
    while len(st) > 1:
        a = st.pop()
        b = st.pop()

        if int(arr[a][b]) == 1:
            st.append(b)
        else:
            st.append(a)

    # Possible Celebrity
    pc = st.pop()     
    
    for i in range(len(arr)):
        if i != pc:
            if int(arr[i][pc]) == 0 or int(arr[pc][i]) == 1:
                print("none")
                return

    print(pc,end="\n")



n = int(input())
arr = []

for i in range(n):          
    row = input()
    arr.append(row)

findCelebrity(arr)
