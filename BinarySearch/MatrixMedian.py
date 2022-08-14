#from bisect import bisect_right as upper_bound
def BS(r,mid):
    l = 0
    h = len(r)- 1
    while l <= h:
        m = l + (h - l) // 2
        if r[m] <= mid:
            l = m + 1
        else:
            h = m - 1
    return l


def getMedian(matrix):
    r = len(matrix)
    c = len(matrix[0])
    s=1
    e=10**5
    #for decreasing search space use below for loop 
#     for i in range(r):
#         if matrix[i][0] < s:
#             s = matrix[i][0]
#         if matrix[i][c - 1] > e:
#             e = matrix[i][c - 1]

    desiredcount = (r * c)  // 2
    while s <= e:
        mid = s + (e - s) // 2
        count = 0
        for i in range(r):
            count+=BS(matrix[i],mid)
            #binary search can also be done using bisect_right like below
            #count+=upper_bound(matrix[i],mid)

        if count <= desiredcount:
            s = mid + 1
        else:
            e = mid - 1
    return s
# #bisect_right-The bisect_right() method returns the position on which a new element can be inserted into an already sorted Python list,
# while maintaining the sorted order. If there are one or more elements present with the same 
# value as the new value then the insertion point is past the right side of the last such element.
#tc of bisect_right-O(log(n)), as it is based on the concept of binary search.
# Time Complexity: O(32 * r * log(c)). The upper bound function will take log(c) time and is performed for each row. And since the numbers will be max of 32 bit, 
#     so binary search of numbers from min to max will be performed in at most 32 ( log2(2^32) = 32 ) operations. 
    
    # for above code tc will be O(35 * r * log(c))
#Auxiliary Space: O(1) 

#tutorial video:- https://www.youtube.com/watch?v=tFdBRcHLSGQ
#ide:https://www.codingninjas.com/codestudio/problems/873378?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
