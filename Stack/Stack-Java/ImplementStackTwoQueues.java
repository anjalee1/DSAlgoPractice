import java.util.LinkedList;
import java.util.Queue;

class StackTwo{
    Queue<Integer> q1;
    Queue<Integer> q2;
    StackTwo(){
        q1=new LinkedList<Integer>();
        q2=new LinkedList<Integer>();
    }
    void push(int val){
        q2.add(val);
        while(!q1.isEmpty()){
            int q1front=q1.remove();
            q2.add(q1front);

        }
        Queue<Integer> q = q1;
        q1=q2;
        q2=q;
    }

    int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.remove();
    }

    int top(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }
    int size()
    {
        return q1.size();
    }

}

public class StackUsingTwoQueues {
    public static void main(String[] args){
        StackTwo s = new StackTwo();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.printf("top: %d\n",s.top());
        System.out.printf("pop: %d\n",s.pop());
        System.out.printf("top: %d\n",s.top());
        System.out.printf("pop: %d \n",s.pop());
        System.out.printf("top: %d\n",s.top());

        System.out.println("current size: " + s.size());
    }
}

//tc : push=>o(n)
//pop=>o(1)

