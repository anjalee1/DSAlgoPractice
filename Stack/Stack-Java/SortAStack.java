
//Recursion 
//tc=o(n2)
//sc=o(n)
  
 //ide: https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?leftPanelTab=1
  //video- 6th que :https://www.youtube.com/watch?v=BmZnJehDzyU&t=3017
 // tc expanation: https://www.enjoyalgorithms.com/blog/sort-stack-using-temporary-stack
//

// Expand it!

// T(n) = T(n-1) + n = T(n-2) + (n-1) + n = T(n-3) + (n-2) + (n-1) + n

// and so on, until

// T(n) = 1 + 2 + ... + n = n(n+1)/2   [= O(n^2)]

// provided that T(1) = 1

import java.util.*;

public class Solution {
    public static void sortedInsert(int num ,Stack<Integer> stack) {
        if(stack.empty() || (!stack.empty() && stack.peek()<num)){
            stack.push(num);
            return;
        }
        int val=stack.pop();
        sortedInsert(num ,stack);
        stack.push(val);
        
    }
    
    
	public static void sortStack(Stack<Integer> stack) {
        if(stack.empty()){
            return;
        }
        int num=stack.pop();
        sortStack(stack);
        sortedInsert(num,stack);
        
  }

}

//Method -2 Using another stack
//tc=o(n2)
//sc=o(n)
  
 //ide: https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?leftPanelTab=1
 // code& tc expanation: https://www.enjoyalgorithms.com/blog/sort-stack-using-temporary-stack


