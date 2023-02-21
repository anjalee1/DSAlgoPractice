//ide:https://leetcode.com/problems/fibonacci-number/
//sol:https://www.youtube.com/watch?v=94dfRrDANRY&t=6s

//recursion : tc: 2^n ,sc:o(n)

class Solution {
    public int fib(int n) {

        if(n==0 || n==1) return n;

        int fib1=fib(n-1);
        int fib2=fib(n-2);

        return fib1 +fib2;
        
    }
}



//memorization: tc: o(n),sc:o(n)

class Solution {
    public int fib(int n) {
     int[] mem=new int[n+1];
     return fibMem(n ,mem);
    }


public int fibMem(int n ,int[] mem){
    if(n==0 || n==1) return n;
    if(mem[n]!=0) return mem[n]; 
    int fib1=fib(n-1);
    int fib2=fib(n-2);
    mem[n]=fib1 +fib2;
    return mem[n];
}   

}

//tabulation : tc: o(n),sc:o(n)
class Solution {
    public int fib(int n) {
    if(n==0 || n==1) return n;
     int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i =2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}


//space optimized tc: o(n),sc:o(1)
class Solution {
    public int fib(int n) {
    if(n==0 || n==1) return n;
     
    int a=0;
    int b=1;
    for(int i =2;i<=n;i++){
        int c=a+b;
        a=b;
        b=c;
    }
    return b;
    }
}
