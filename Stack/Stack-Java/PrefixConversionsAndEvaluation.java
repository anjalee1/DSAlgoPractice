
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
    Stack<String> postfix=new Stack<>();

    for(int i=exp.length()-1;i>=0;i--){
        char ch= exp.charAt(i);
        if(ch=='+'|| ch=='-'|| ch=='/' || ch=='*'){
            int val1=result.pop();
            int val2=result.pop();
            int resultval=operation(val1,val2,ch);
            result.push(resultval);


            String in1=infix.pop();
            String in2=infix.pop();
            infix.push('('+in1+ch+in2+')');

            String pre1=postfix.pop();
            String pre2=postfix.pop();
            postfix.push(pre1+pre2+ch);


        }
        else{
            result.push(ch-'0');
            infix.push(ch+"");
            postfix.push(ch+"");
        }
    }

    System.out.println(result.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());

 }
}
