//ide :https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
//sol:https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48
//https://takeuforward.org/data-structure/job-sequencing-problem/

//Time Complexity: O(N log N) 
//O(N log N ) 
Gemini said
Here is the breakdown of the Time Complexity for the Priority Queue (Min-Heap) approach.

The Short Answer
The total time complexity is O(NlogN), where N is the number of jobs.

The Detailed Breakdown
The algorithm has two main parts:

1. Sorting the Jobs
Action: We sort the jobs array based on deadlines.

Cost: Java's Arrays.sort or Collections.sort uses a variant of Merge Sort / TimSort.

Complexity: O(NlogN)

2. Iterating and Heap Operations
We iterate through every job exactly once (N times). Inside this loop, we perform Heap operations.

pq.add(profit): Inserting into a Min-Heap takes logarithmic time relative to the size of the heap. In the worst case, the heap holds all N jobs.

Cost: O(logN)

pq.poll(): Removing the minimum element also takes logarithmic time.

Cost: O(logN)

Since we do these operations inside a loop that runs N times:

Loop Complexity: N×O(logN)=O(NlogN)

Total Calculation
Total Time=Sorting+Heap Loop
Total Time=O(NlogN)+O(Nlog
Space Complexity$O(N)$: We need space to store the list of jobs and the Priority Queue, which can hold up to $N$ elements. 
	This is much safer than $O(\text{MaxDeadline})$ because deadlines can be huge numbers (e.g., $10^9$) even if $N$ is small.
/// new code
import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // 1. Create a simpler structure to hold jobs
        int n = deadline.length;
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i]});
        }

        // 2. Sort by DEADLINE in ASCENDING order
        // Note: This is different from your previous approach!
        Collections.sort(jobs, (a, b) -> a[0] - b[0]);

        // 3. Use a Min-Heap to store profits of accepted jobs
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long totalProfit = 0; // Use long to prevent overflow (though int usually suffices here)

        for (int[] job : jobs) {
            int currentDeadline = job[0];
            int currentProfit = job[1];

            // Add current job's profit to the heap
            pq.add(currentProfit);
            totalProfit += currentProfit;

            // If we have more jobs than the current deadline allows,
            // remove the job with the SMALLEST profit (regret strategy)
            if (pq.size() > currentDeadline) {
                totalProfit -= pq.poll();
            }
        }

        // 4. Return count (heap size) and total profit
        return new ArrayList<>(List.of(pq.size(), (int) totalProfit));
    }
}
