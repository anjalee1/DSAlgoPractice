
class MinStack {
    Stack<Long> st;
    long min;
    
    public MinStack() {
      st = new  Stack<Long>();
      min = Integer.MAX_VALUE;
    }
    
    public void push(long val) {
       if(st.empty()){
           st.push(val);
           min=val;
       }
       else if(val<min){
           st.push(val+(val-min));
            min=val;
       }
       else{
           st.push(val);
       }
    }
    
    public void pop() {
        long pop =st.pop();
        if(pop<min){ 
           min=2*min-pop;
           
        }
    }
    
    public long top() {
      if(st.peek()<min){
          return min;
      }
     else{
          return st.peek();
        }
    }
    
    public long getMin() {
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
