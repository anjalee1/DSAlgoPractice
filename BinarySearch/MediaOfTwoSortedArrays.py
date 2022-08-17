import sys

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)>len(nums2):
         temp=nums1
         nums1=nums2
         nums2=temp
        lo=0
        hi=len(nums1)
        tl=len(nums1)+len(nums2)
        while lo<=hi:
            aleft=(hi-lo//2)+lo
            bleft=(tl+1)//2-aleft
            alm1=-sys.maxsize-1 if aleft == 0 else nums1[aleft-1]
            al=sys.maxsize if aleft == len(nums1) else nums1[aleft]
            blm1=-sys.maxsize-1 if bleft == 0 else nums2[bleft-1]
            bl=sys.maxsize if bleft == len(nums2) else nums2[bleft]
            if alm1<=bl and blm1 <=al:
                if tl%2==0:
                    median=(max(alm1,blm1)+min(al,bl))/2
                else:
                    median=max(alm1,blm1)
                return median
            elif alm1 > bl:
                hi=aleft-1
            elif blm1>al:
                lo=aleft+1
            
            #Tutotial video:- https://www.youtube.com/watch?v=nv7F4PiLUzo&t=752s
            #tc=> o(log2(min(n,m)))
