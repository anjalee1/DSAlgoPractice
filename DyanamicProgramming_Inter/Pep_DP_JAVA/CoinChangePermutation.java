//ide: https://nados.io/question/coin-change-permutations
//sol: https://www.youtube.com/watch?v=yc0LunmJA1A

//tc: o(tar*n)
//oc:o(tar)


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] coins = new int[n];

        for(int i=0;i<coins.length;i++){
            coins[i]= scn.nextInt();

        }

        int tar = scn.nextInt();

        int[] dp= new int[tar+1];
        dp[0]=1;

        for(int amt=1;amt<=tar;amt++){
            for(int coin:coins){

                if(coin<=amt){
                    int ramt=amt-coin;
                    dp[amt]+=dp[ramt];
                }

            }

        }

        System.out.println(dp[tar]);

    }
}
