//IDE:https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
//SOL:https://www.youtube.com/watch?v=F_DDzYnxO14&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
//https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/

Complexity Analysis1. 
	//Time Complexity: $O(N \log N)$Creating Objects: We iterate through the arrays once to create the Item objects. This takes $O(N)$.Sorting: This is the most expensive step. Sorting $N$ items takes $O(N \log N)$.Selection Loop: We iterate through the sorted items at most once. This takes $O(N)$.Total: The sorting dominates, so the overall complexity is $O(N \log N)$.2. 
	//Space Complexity: $O(N)$We create a custom array of Item objects to store the values, weights, and ratios combined. This requires $O(N)$ auxiliary space.


//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Item{
    int val;
    int wt;
    double ratio;
    Item(int val,int wt){
        this.val=val;
        this.wt=wt;
        this.ratio=(double)val/(double)wt;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
       Item[] items= new Item[val.length];
       
       for(int i=0;i<val.length;i++){
          items[i] = new Item(val[i], wt[i]);
       }
       
       Arrays.sort(items,(a,b)->Double.compare(b.ratio, a.ratio));
       double value=0;
       int currentCapacity=capacity;
       for(int i=0;i<items.length;i++){
           if(currentCapacity>=items[i].wt){
               value+=items[i].val;
               currentCapacity-= items[i].wt;
           }
           else{
               value+=items[i].ratio * currentCapacity;
               break;
           }
       }
       return value;
    }
}
