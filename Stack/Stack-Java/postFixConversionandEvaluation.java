import java.io.*;
import java.util.*;

public class Main{
  
public static int operation(int v1 ,int v2,char operator){
    if(operator =='+'){
        return v1+v2;

    }
    else if(operator =='-'){
        return v1-v2;
    }

    else if(operator =='*'){
        return v1*v2;
    }

    else{
        return v1/v2;
    }
}
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Stack<Integer> result=new Stack<>();
    Stack<String> infix=new Stack<>();
    Stack<String> prefix=new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch= exp.charAt(i);
        if(ch=='+'|| ch=='-'|| ch=='/' || ch=='*'){
            int val2=result.pop();
            int val1=result.pop();
            int resultval=operation(val1,val2,ch);
            result.push(resultval);


            String in2=infix.pop();
            String in1=infix.pop();
            infix.push('('+in1+ch+in2+')');

            String pre2=prefix.pop();
            String pre1=prefix.pop();
            prefix.push(ch+pre1+pre2);


        }
        else{
            result.push(ch-'0');
            infix.push(ch+"");
            prefix.push(ch+"");
        }
    }

    System.out.println(result.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());


    
 }
}
