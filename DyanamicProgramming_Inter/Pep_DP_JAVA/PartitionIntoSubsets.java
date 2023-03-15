//ide:https://nados.io/question/partition-into-subsets
//sol:https://www.youtube.com/watch?v=IiAsqfjhZnY&t=4s

//tc: o(k*n)
//sc: o(k*n)

import java.io.*;
import java.util.*;

public class Main {
    
    public static long partitionKSubset(int n, int k) {
        if(k==0 || n==0 || n<k){
            return 0;
        }

        long dp[][]= new long[k+1][n+1];

        for(int t=1;t<=k;t++){
            for(int p=1;p<=n;p++){

                if(t==p){

                  dp[t][p]=1;
                }
                else if(p<t){
                  dp[t][p]=0;
                }
                else{
                    dp[t][p]=(t*dp[t][p-1])+dp[t-1][p-1];
                }

            }
        }

        return dp[k][n];


    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
