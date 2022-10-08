

//ide: https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?leftPanelTab=0
//sol:https://www.youtube.com/watch?v=YTTdLgyqOLY&t=1141s

// Time Complexity: O(N*log(M)). 
// Reason: For binary search in a space of M, O(log(M))  and for each search, we iterate over max N stalls to check. O(N).

// Space Complexity: O(1)


import java.util.*;

public class Solution 
{
    
    public static boolean isPossible(ArrayList<Integer> stalls, int k, int mid, int n) {
    
    int cowCount = 1;
    int lastPos = stalls.get(0);
    
    for(int i=0; i<n; i++ ){
        
        if(stalls.get(i)-lastPos >= mid){
            cowCount++;
            if(cowCount==k)
            {
                return true;
            }
            lastPos = stalls.get(i);
        }
    }
    return false;
 }
    
    
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
       Collections.sort(stalls);  
        int s = 0;
        int n = stalls.size();
        int e=stalls.get(n-1);
        int ans = -1;
       
        
        while(s<=e) {
        int mid = s + (e-s)/2;
        if(isPossible(stalls, k, mid, n)) {
            ans = mid;
            s = mid + 1;
        }
        else
        {
            e = mid - 1;
        }
        }
        return ans;
    }
}
