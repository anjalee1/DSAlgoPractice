//TC: O(N+N+NlogK)
// Hashing: O(N)
// build heap:O(N)
// extraxt max k times: O(klogN)
//   ..>extract max from heap takes logN if number of elements are N in heap
//   ..>it takes logN time because after popping max ele ,max heapify is done to maintain order of heap which takes logN time

// video solution:https://www.youtube.com/watch?v=Wh3A29psE_Y
// code link: https://techdose.co.in/top-k-frequent-elements/
// ide: https://leetcode.com/problems/top-k-frequent-elements/
  
