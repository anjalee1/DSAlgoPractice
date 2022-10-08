
//ide:https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//sol:https://www.youtube.com/watch?v=okP-e2VpI_g
// Time Complexity : O(NlogN)
// Reason: Binary search takes O(log N). For every search, we are checking if an allocation is possible or not. Checking for allocation takes O(N).
// Space Complexity: O(1)
// Reason: No extra data structure is used to store spaces.

import java.util.* ;
import java.io.*; 
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
       int  maxTime=Integer.MIN_VALUE;;
        long sum=0;
        long answer =0;
        for(int i =0;i<m;i++){
             sum += time[i];
             maxTime = Math.max(maxTime , time[i]);
        }
        long l=maxTime,r=sum;
       while(l<=r){
            long mid = (l + r) / 2;
            long days = 1;
            long currentTime = 0;
           
            for (int i = 0; i < m; i++) {
                currentTime += time[i];
                if (currentTime > mid) {
                    days++;
                    currentTime = time[i];
                }

            }
           
            if (days <= n) {
                answer = mid;
                r = mid - 1;
            }

            else {
                l = mid + 1;
            }


       }
        
        return answer;
    }
    
   
}
