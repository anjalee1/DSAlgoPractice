import java.io.*;
import java.util.*;

public class Main{

    public static int precedance(char op){
    if(op == '+'){
      return 1;
    } else if(op == '-'){
      return 1;
    } else if(op == '*'){
      return 2;
    } else {
      return 2;
    }
  }

  public static int operation(int val1, int val2, char op){
    if(op == '+'){
      return val1 + val2;
    } else if(op == '-'){
      return val1 - val2;
    } else if(op == '*'){
      return val1 * val2;
    } else {
      return val1 / val2;
    }
  }
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
    
        Stack<Integer> operands=new Stack<Integer>();
        Stack<Character> operators=new Stack<Character>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isDigit(ch)){
                operands.push(ch-'0');
            }
            else if(ch=='('){
                operators.push(ch);
    
            }
    
            else if(ch==')'){
                while(operators.size() > 0 && operators.peek()!='('){
                    char op=operators.pop();
                    int b =operands.pop();
                    int a =operands.pop();
                    int opv=operation(a,b,op);
                    operands.push(opv);
                }
    
                if (operators.size() > 0) {
                      operators.pop();
                }
                
            }
    
            else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
                while(operators.size()>0 && operators.peek()!='(' 
                      && precedance(ch)<=precedance(operators.peek())){
                    char op=operators.pop();
                    int b =operands.pop();
                    int a =operands.pop();
                    int opv=operation(a,b,op);
                    operands.push(opv);
    
                }
                operators.push(ch);
                
            }
        }
    
        System.out.println(operands.peek());
       
     }
}
