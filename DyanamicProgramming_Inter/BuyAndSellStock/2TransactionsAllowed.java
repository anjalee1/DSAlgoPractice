//ide:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//sol: https://www.youtube.com/watch?v=wuzTpONbd-0&list=TLGGyjcZwMrklxEwNTA3MjAyMw


class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;

        int lsf=prices[0];
        int mpist=0;
        int dpl[] =new int[n];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<lsf){
                lsf=prices[i];
            }
            mpist=prices[i]-lsf;
            if(mpist>dpl[i-1]){
                dpl[i]=mpist;
            }
            else{
                dpl[i]=dpl[i-1];
            }
        }

        int mat=prices[n-1];
        int mpibt=0;
        int dpr[] =new int[n];
        for(int i=n-2;i>=0;i--){
            if(prices[i]>mat){
                mat=prices[i];
            }
            mpibt=mat-prices[i];
            if(mpibt>dpr[i+1]){
                dpr[i]=mpibt;
            }
            else{
                dpr[i]=dpr[i+1];
            }
        }

        int op=0;
        for(int i=0;i<prices.length;i++){
            if(dpl[i]+dpr[i]>op){
                op=dpl[i]+dpr[i];
            }
        }
        return op;
    }
}
