
class StockSpanner {
    Stack<int []> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
     int span =1; 
      while(st.size()>0 && st.peek()[0]<=price){
          span+=st.pop()[1];
      }
        st.push(new int[]{price,span});
      return span;
    }
}

//leetcode link : https://leetcode.com/problems/online-stock-span/submissions/
//tc:o(n)

//sc:o(n)

//refer to picture in this solution for better understanding: https://leetcode.com/problems/online-stock-span/discuss/640648/Clean-Java-Stack-solution-with-explanation.-90-better-run-time
//tc explanation at 11:54: https://www.youtube.com/watch?v=lGWLBgwd-cw
