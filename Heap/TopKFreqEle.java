//TC: O(N+N+NlogK)
// Hashing: O(N)
// build heap:O(N)
// extraxt max k times: O(klogN)
//   ..>extract max from heap takes logN if number of elements are N in heap
//   ..>it takes logN time because after popping max ele ,max heapify is done to maintain order of heap which takes logN time

// video solution:https://www.youtube.com/watch?v=Wh3A29psE_Y
// code link: https://techdose.co.in/top-k-frequent-elements/
// ide: https://leetcode.com/problems/top-k-frequent-elements/
  
import java.util.*;  

class Solution {
    
    static class Pair {
        int ele;
        int freq;
        Pair(int ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }
    } 
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int ele: nums){
            if (freqMap.containsKey(ele)) {
                freqMap.put(ele, freqMap.get(ele) + 1);
            }
            else {
                freqMap.put(ele, 1);
            }  
        }
        
        Comparator<Pair> PairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.freq - p1.freq;
            }
        };
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(PairComparator);
        for(Map.Entry<Integer,Integer> mapElement : freqMap.entrySet()){
            pq.add(new Pair(mapElement.getKey(),mapElement.getValue()));
        }
        
        int[] ans=new int[k];
        int i=0;
      
        while(i<k){
            Pair p=pq.remove();
            ans[i]=p.ele;
            i++;
        }
        return ans;   
    }
}
