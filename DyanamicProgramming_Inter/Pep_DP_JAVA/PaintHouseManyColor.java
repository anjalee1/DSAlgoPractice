//ide:https://nados.io/question/paint-house-many-colors
//sol:https://www.youtube.com/watch?v=jGywRalvoRw&t=3s

//tc:o(n*k)
//sc:o(n*k)

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int k = scn.nextInt();
         int arr[][] = new int[n][k];
         for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
              arr[i][j]=scn.nextInt();
            }
            
         }

         long least=Integer.MAX_VALUE;
         long sleast=Integer.MAX_VALUE;

         long dp[][]= new long[n][k];
        

         for(int j=0;j<k;j++){
             dp[0][j]=arr[0][j];

             if(arr[0][j]<=least){
                 sleast=least;
                 least=arr[0][j];
                 

             }
             else if(arr[0][j]<=sleast){
                 sleast=arr[0][j];

             }
         }


         for(int i=1;i<n;i++){
             long nleast=Integer.MAX_VALUE;
             long nsleast=Integer.MAX_VALUE;
             for(int j=0;j<k;j++){
                 if(least==dp[i-1][j]){
                     dp[i][j]=arr[i][j]+sleast;
                 }
                 else{

                     dp[i][j]=arr[i][j]+least;

                 }

                 if(dp[i][j]<=nleast){
                     nsleast=nleast;
                     nleast=dp[i][j];
                 

                }
                else if(dp[i][j]<=nsleast){
                    nsleast=dp[i][j];

                }

             }
             least=nleast;
             sleast=nsleast;
         }

         System.out.println(least);
         


    }
}
