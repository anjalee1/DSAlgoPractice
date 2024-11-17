//solution: https://www.youtube.com/watch?v=v-Ta5GyxRxc&t=500s
//tc: klogk (explanation in sol video)
//ide : hhttps://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->a-b);

        for(int i=0;i<k;i++){
            minHeap.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);

            }
        }

        return minHeap.peek();

    }
}



