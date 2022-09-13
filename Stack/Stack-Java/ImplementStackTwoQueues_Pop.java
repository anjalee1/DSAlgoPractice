import java.util.LinkedList;
import java.util.Queue;

class StackThree{
    Queue<Integer> q1;
    Queue<Integer> q2;
    StackThree(){
        q1=new LinkedList<Integer>();
        q2=new LinkedList<Integer>();
    }
    void push(int val){
        q1.add(val);
    }

    int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size()!=1){
            q2.add(q1.remove());
        }
        int pop=q1.remove();
        Queue q=q1;
        q1=q2;
        q2=q;
        return pop;
    }

    int top(){
        if(q1.isEmpty()){
            return -1;
        }

        while(q1.size()!=1){
            q2.add(q1.remove());
        }
        int temp=q1.remove();
        q2.add(temp);

        Queue<Integer> q =q1;
        q1=q2;
        q2=q;
        return temp;
    }
    int size()
    {
        return q1.size();
    }
}


public class PopStackUsingTwoQueues {

    public static void main(String[] args){
        StackThree s = new StackThree();
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
//tc : push=>o(1)
//pop=>o(n)
