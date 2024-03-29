//ide: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//sol: https://www.youtube.com/watch?v=4YjEHmw1MX0&t=4s
//tc:o(n)
//sc:o(1)

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/1569081/java-simple-clean-dp-solutions-for-all-6-buy-sell-stock-questions-on-leetcode/?orderBy=most_votes

class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int lsf= Integer.MAX_VALUE;
       int op=0;
       int pist=0;

       for(int i=0;i<prices.length;i++){
           if(prices[i]<lsf){
               lsf=prices[i];
           }
           pist=prices[i]-lsf;
           if(pist>op){
              op=pist; 
           }
       }
       return op;
    }
}
