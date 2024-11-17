



//ide:https://leetcode.com/problems/top-k-frequent-elements/description/
//sol: https://chatgpt.com/g/g-2DQzU5UZl-code-copilot/c/6739c287-54e0-8004-b04e-7d8d3f08ca71
//https://www.youtube.com/watch?v=Wh3A29psE_Y

///*
 * Complexity Analysis:
 * 
 * Time Complexity:
 * 1. Counting frequencies takes O(n).
 * 2. Inserting into the min-heap takes O(log k) for each element.
 *    Thus, for all unique elements, it takes O(n log k).
 * 
 * Space Complexity:
 * 1. O(n) for storing the frequency map.
 * 2. O(k) for the min-heap since it stores only the top k elements.
 */



import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a min-heap (PriorityQueue) to keep the top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the lowest frequency
            }
        }
        
        // Step 3: Extract the keys of the top k elements from the min-heap into an array
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }
        
        return result;
    }
}
