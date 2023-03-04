//ide:https://nados.io/question/paint-fence
//sol: https://www.youtube.com/watch?v=ju8vrEAsa3Q&t=7s

//tc:o(n)
//sc:o(1)

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long same = k*1;
        long diff=k*(k-1);
        long total=same +diff; 
         for(int i =3;i<=n;i++){

             same =diff*1;
             diff=total*(k-1);
             total=same+diff;
            
         }

         System.out.println(total);


    }
}

