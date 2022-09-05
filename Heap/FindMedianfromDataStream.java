import java.util.*;

class MedianFinder {
    
    static class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y-x; //reverse order
        }
    } 
   
    PriorityQueue<Integer> maxHeap;//first half
    PriorityQueue<Integer> minHeap;//second half
    
    public MedianFinder() {//initialize your data structure here
          minHeap= new PriorityQueue<>();
          maxHeap=new PriorityQueue<>(new maxHeapComparator());
    }
    
    
    public void addNum(int num) {
        int lsize=maxHeap.size();
        int rsize=minHeap.size();
        if(lsize==0){//num is the 1st element in stream
            maxHeap.add(num);
        }
        else if(lsize==rsize){//Push one element in maxheap for sure
              if(num<minHeap.peek()){//num can be pushed to maxheap (1st half) to maintain order
                  maxHeap.add(num);       
              }
              else{
                  int temp=minHeap.peek();//Save root of minheap
                  minHeap.remove(); //Pop the root from minheap
                  minHeap.add(num);//Push num in minhea
                  maxHeap.add(temp);//Push the previous saved root of minheap in the maxheap
              }
            
             
        
        }
        else{
             if(minHeap.size()==0){
                if(num>maxHeap.peek()) //Push num to 2nd half
                    minHeap.add(num);
                else //Push num to 1st half
                {
                    int temp = maxHeap.peek();
                    maxHeap.remove();
                    maxHeap.add(num);
                    minHeap.add(temp);
                }
            }
            else if(num>=minHeap.peek()) //Push the element directly in minheap (2nd half)
                minHeap.add(num);
            else    //Push root of maxheap to minheap
            {
                if(num<maxHeap.peek())   //Push num to 1st half
                {
                    int temp = maxHeap.peek();   //Save root of maxheap
                    maxHeap.remove();  //Pop root of maxheap
                    maxHeap.add(num);  //Push num to maxheap
                    minHeap.add(temp); //Push previous saved root of maxheap to minheap
                }
                else    //Push num to 2nd half
                    minHeap.add(num);
            }
            
            
            
        }
        
            
    }
    
    public double findMedian() {
        int lsize = maxHeap.size();
        int rsize = minHeap.size();
        double median;
        if(lsize > rsize){  //Return top of maxheap for odd no of elements
            median= maxHeap.peek();      
        }
        else {   //Else return avg of top of maxheap and minheap
            double mxv=maxHeap.peek();
            double mnv=minHeap.peek();
            median=(mxv+mnv)/2;
        }
         return median;
    }
}
//TC: o(nlogn)
//video: https://www.youtube.com/watch?v=1LkOrc-Le-Y
//codelink:https://techdose.co.in/median-from-data-stream/
//ide : https://leetcode.com/problems/find-median-from-data-stream/
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
