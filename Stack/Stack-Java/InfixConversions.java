//https://www.youtube.com/watch?v=f29emeUcw6c&t=961s

import java.io.*;
import java.util.Stack;

public class InfixConversion{

    public static int precedence(char op){
        if(op == '/' || op=='*'){
            return 1;
        } else if(op == '+' || op=='-'){
            return 2;
        }
        else {
            return 0;
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> prefix=new Stack<String>();
        Stack<String> postfix=new Stack<String>();
        Stack<Character> operator=new Stack<Character>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='('){
                operator.push(ch);

            }

            else if ((ch >='0' && ch <= '9') || (ch >='a' && ch <= 'z') || (ch >='A' && ch <= 'Z')){

                prefix.push(ch+"");
                postfix.push(ch+"");

            }

            else if(ch=='-'|| ch=='+'||ch=='/'|| ch=='*'){

                while(operator.size()>0 && operator.peek() != '('&& precedence(operator.peek())>=precedence(ch)){
                    char op=operator.pop();
                    String pre2=prefix.pop();
                    String pre1=prefix.pop();

                    prefix.push(op+pre1+pre2);

                    String post2=postfix.pop();
                    String post1=postfix.pop();

                    postfix.push(post1+post2+op);


                }

                operator.push(ch);
            }

            else if(ch==')'){

                while(operator.size()>0 && operator.peek() != '(') {
                    char op=operator.pop();
                    String pre2=prefix.pop();
                    String pre1=prefix.pop();

                    prefix.push(op+pre1+pre2);

                    String post2=postfix.pop();
                    String post1=postfix.pop();

                    postfix.push(post1+post2+op);


                }
                if(operator.size()>0){
                    operator.pop();
                }



            }
        }
        while(operator.size()>0) {
            char op=operator.pop();
            String pre2=prefix.pop();
            String pre1=prefix.pop();

            prefix.push(op+pre1+pre2);

            String post2=postfix.pop();
            String post1=postfix.pop();

            postfix.push(post1+post2+op);


        }

        System.out.println(postfix.pop());
        System.out.println(prefix.pop());


    }
}

