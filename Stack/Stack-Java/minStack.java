
class MinStack {
    Stack<Integer> as;
    Stack<Integer> min;
    
    public MinStack() {
      as = new  Stack<Integer>();
      min = new Stack<Integer>();
    }
    
    public void push(int val) {
         as.push(val);
        if(min.empty()||val<=.peek()){
            min.push(val);
        }  
    }
    
    public void pop() {
        int val =as.peek();
        as.pop();
        if(val==min.peek()){
            min.pop();
        }
    }
    
    public int top() {
       return as.peek() ;
    }
    
    public int getMin() {
        return min.peek();
        
    }
}
