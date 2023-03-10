//ide:https://nados.io/question/tiling-with-m-1-tiles
//sol:https://www.youtube.com/watch?v=_c_R-uIi-zU&t=2s

//tc:o(n),sc:o(n)




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int dp[]= new int[n+1];

        for(int i=1;i<=n;i++){
           if(i<m){
               dp[i]=1;

           }
           else if(i==m){
               dp[i]=2;
           }
           else{
               dp[i]=dp[i-1]+dp[i-m];
           }
        }

        System.out.println(dp[n]);


    }
}
