
/////refer: https://www.codingninjas.com/codestudio/library/find-the-leftmost-and-rightmost-set-bit-of-a-number

///////////xor method
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        int x, y;
        int xor1;
 
        /* Will have only single set bit of xor1 */
        int set_bit_no;
 
        int i;
        x = 0;
        y = 0;
 
        xor1 = arr[0];
 
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
 
        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
 
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
 
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
 
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
        
        int countx=0;
        int county=0;
        
        int[] res =new int[2];
        for(i=0;i<arr.length;i++){
            if(arr[i]==x){
               countx++; 
            }
            else if(arr[i]==y){
                county++;
                
            }
        }
        
        if(countx==0){
            res[0] =y;
            res[1]=x;
            
        }
        else{
            res[0]=x;
            res[1]=y;
        }
        
        return res;
    }
}


//ide:https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol: https://www.youtube.com/watch?v=5nMGY4VUoRY
//https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/

// Time Complexity: O(N) 
// Space Complexity: O(1) 


///////mathematical approach

//ide:https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//sol: https://www.youtube.com/watch?v=5nMGY4VUoRY
//https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/

// Time Complexity: O(N) 
// Space Complexity: O(1) 
class Solve {
    long[] findTwoElement(int arr[], int n) {
        
    long len = arr.length;

    long S = (len * (len+1) ) /2;
    long P = (len * (len +1) *(2*len +1) )/6;
    int missingNumber=0, repeating=0;
     
    for(int i=0;i<len; i++){
       S -= arr[i];
       P -= arr[i]*arr[i];
    }
     
    missingNumber = (S + P/S)/2;

    repeating = missingNumber - S;

    long[] res =new long[2];

    res[0]=repeating;
    res[1]=missingNumber;

    return res;
    }
}



