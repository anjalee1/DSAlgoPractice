//ide: https://nados.io/question/count-binary-strings
//sol:https://www.youtube.com/watch?v=nqrXHJWMeBc&t=3s

//tc:o(n)
//sc: o(n)

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
   Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();

   int oczeroes= 1;
   int ocones=1;

   for(int i=2;i<=n;i++){
       int nczeros=ocones;
       int ncones=oczeroes+ocones;

       oczeroes=nczeros;
       ocones=ncones;

   }

   System.out.println(oczeroes+ocones);
   
 }

}
