import bisect



class Solution:

    # @param A : list of list of integers

    # @return an integer

    def findMedian(self, A):

        

        temp = []

        

        for i in range(0, len(A)):

            for j in range(0, len(A[0])):

                temp.append(A[i][j])

        

        temp.sort()

        

        return temp[len(temp)//2]

        

        l = 0

        r = 1000*1000*1000

        req = len(A) * len(A[0])

        assert(req % 2);

        while(r - l > 1):

            mid = l + (r - l) / 2

            cnt = 0

            for i in A: 

                #using upper bound in a sorted array to count number of elements smaller than mid

                low = 0

                p = bisect.bisect_right(i, mid)

                cnt += p

            if cnt >= (req/2 +1):

                r = mid

            else:

                l = mid
