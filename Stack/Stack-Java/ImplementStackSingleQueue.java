
import java.util.LinkedList;
import java.util.Queue;

class Stack{
    Queue<Integer> q;
    Stack(){
        q=new LinkedList<Integer>();
    }

    void push(int val){
        // get previous size of queue
        int size = q.size();

        // Add current element
        q.add(val);

        // Pop (or Dequeue) all previous
        // elements and put them after current
        // element
        for (int i = 0; i < size; i++)
        {
            // this will add front element into
            // rear of queue
            int x = q.remove();
            q.add(x);
        }
    }

    int pop()
    {
        if (q.isEmpty())
        {
            System.out.println("No elements");
            return -1;
        }
        int front= q.remove();//The remove() method of Queue Interface returns and removes the element at the front of the container.
                               // It deletes the head of the container.
        return front;
    }

    int top()
    {
        if (q.isEmpty())
            return -1;
        return q.peek();//The peek() method of Queue Interface returns the element at the front
    }

    boolean isEmpty()
    {
        return q.isEmpty();
    }

}

public class StackUsingQueue {
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.println("Top element :" + s.top());
        s.pop();
        s.push(30);
        s.pop();
        System.out.println("Top element :" + s.top());
    }
}
