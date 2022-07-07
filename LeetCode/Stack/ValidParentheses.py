from collections import deque
class Solution:
   
    def isValid(self, s):
        stack = deque()
        dict = {"]":"[", "}":"{", ")":"("}
        for char in s:
            if char in dict.values():
                stack.append(char)
            elif char in dict.keys():
                if len(stack) == 0 or dict[char] != stack.pop():
                    return False
            else:
                return False
        return len(stack)==0
                
