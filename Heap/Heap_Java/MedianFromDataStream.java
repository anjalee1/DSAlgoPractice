


//ide: https://leetcode.com/problems/find-median-from-data-stream/description/
//sol: https://chatgpt.com/g/g-2DQzU5UZl-code-copilot/c/6739b548-23b8-8004-91ee-d5f90f654480
https://www.youtube.com/watch?v=1LkOrc-Le-Y

//// Complexity Analysis
// Time Complexity:
// addNum(): O(log n)
// findMedian(): O(1)

// Space Complexity: O(n)




class MedianFinder {
    private PriorityQueue<Integer> left;  // Max-Heap to store the smaller half
    private PriorityQueue<Integer> right; // Min-Heap to store the larger half

    public MedianFinder() {
        // Initialize the heaps
        left = new PriorityQueue<>((a, b) -> b - a); // Max-Heap
        right = new PriorityQueue<>(); // Min-Heap
    }
    
    public void addNum(int num) {
        // Add to max-heap first
        left.offer(num);
        
        // Balance the heaps by moving the largest element from left to right
        right.offer(left.poll());

        // Ensure left can have at most one extra element than right
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        // If left heap has more elements, return its top element
        if (left.size() > right.size()) {
            return left.peek();
        }
        // Otherwise, return the average of the top elements from both heaps
        return (left.peek() + right.peek()) / 2.0;
    }
}

