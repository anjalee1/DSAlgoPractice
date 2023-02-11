//ide:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//sol:https://www.youtube.com/watch?v=HWJ9kIPpzXs&t=1s
//tc:o(n)
//sc:o(1)

class Solution {
    public int maxProfit(int[] prices) {
       int n= prices.length;
       int profit=0;
       int bd=0;
       int sd=0;

       for(int i=1;i<prices.length;i++){
           if(prices[i]>=prices[i-1]){
              sd++;
           }
           else{
              profit += prices[sd]-prices[bd];
              bd=sd=i;
           }
           
       }
       profit += prices[sd]-prices[bd];
       return profit;
    }
}
