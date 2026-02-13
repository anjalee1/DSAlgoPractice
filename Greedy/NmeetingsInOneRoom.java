
//Time Complexity: O(n) to iterate through every position and insert them in a data structure. O(n log n)  to sort the data structure in ascending order of end time. O(n)  to iterate through the positions and check which meeting can be performed.
//Overall : O(n) +O(n log n) + O(n) ~O(n log n)
//Space Complexity: O(n)  since we used an additional data structure for storing the start time, end time, and meeting no.

//sol: https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=46
//https://takeuforward.org/data-structure/n-meetings-in-one-room/
//ide: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1



//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        
        List<List<Integer>> timings= new ArrayList<>();
        for(int i=0;i<start.length;i++){
            timings.add(List.of(start[i],end[i]));
        }
        int count= 1;
        Collections.sort(timings, (a,b)->a.get(1)-b.get(1));
        int limit = timings.get(0).get(1);
        for(int i=1;i<timings.size();i++){
            if(timings.get(i).get(0)>limit){
                limit=timings.get(i).get(1);
                count++;
            }
            
        }
        
        return count;
    }
}
