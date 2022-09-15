
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
