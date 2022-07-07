from collections import deque
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        widths=[0]*len(heights)
        widths[len(heights)-1]=len(heights)
        stack=deque()
        stack.append(len(heights)-1)
        for i in range(len(heights)-2,-1,-1):
            while len(stack)>0 and heights[stack[-1]]>=heights[i]:
                stack.pop()
            if len(stack)==0:
                widths[i]=len(heights)
            else:
                widths[i]=stack[-1]
            stack.append(i)
        stack=deque()    
        stack.append(0)
        widths[0]=widths[0]-(-1)-1
        for i in range(1,len(heights)):
            while len(stack)>0 and heights[stack[-1]]>=heights[i]:
                stack.pop()
            if len(stack)==0:
                widths[i]= (widths[i]-(-1))-1
            else:
                 widths[i]= (widths[i]-stack[-1])-1
            stack.append(i)
            
        maxArea=0
        for i in range(len(heights)): 
            area=widths[i]*heights[i]
            if area>maxArea:
                maxArea=area
        return maxArea
                
            
