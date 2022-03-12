
def mergeOverlappingIntervals(arr):
    
    # write your code here
    arr.sort(key = lambda x: x[0])
    
    st = []
    for i in range(len(arr)):
        meeting = arr[i]
        sp = meeting[0]
        ep = meeting[1]
        
        if len(st) == 0:
            st.append(meeting)
        else:
            lastmeeting = st.pop()
            if lastmeeting[1] >= sp:
                mergedmeeting = [lastmeeting[0] , max(lastmeeting[1] , ep)]
                st.append(mergedmeeting)
            else:
                st.append(lastmeeting)
                st.append(meeting)
                
    
    # print the list
    for i in range(len(st)):
        interval = st[i]
        print(interval[0] , end = " ")
        print(interval[1],end="\n")
    
    
    



def main():
    n = int(input())
    arr = [ ]
    
    
    # input from user
    for i in range(n):
        narr = []
        inp = str(input()).strip().split(" ")
        narr.append(int(inp[0]))
        narr.append(int(inp[1]))
        arr.append(narr)
    
    
    mergeOverlappingIntervals(arr)



main()
