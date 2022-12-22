//ide :https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
//sol:https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48
//https://takeuforward.org/data-structure/job-sequencing-problem/

//Time Complexity: O(N log N) + O(N*M).
//O(N log N ) for sorting the jobs in decreasing order of profit. O(N*M) since we are iterating through all N jobs and for every job we are checking from the last deadline, say M deadlines in the worst case.

//Space Complexity: O(M) for an array that keeps track on which day which job is performed if M is the maximum deadline available.


