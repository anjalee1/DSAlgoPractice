def printStairPaths(ques, asf):
# write your code here
   if ques<0:
    return
   if ques==0:
    print(asf)
    return
   printStairPaths(ques-1,asf+"1");
   printStairPaths(ques-2,asf+"2");
   printStairPaths(ques-3,asf+"3");
 


ques = int(input())
printStairPaths(ques, "");
