
//ide:https://nados.io/question/tiling-with-2-1-tiles
//sol:https://www.youtube.com/watch?v=dVT9JeUMMDE&t=2s
//tc:o(n),sc:o(n)

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();

        int dp[]= new int[n+1];

        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println(dp[n]);

    }
}
