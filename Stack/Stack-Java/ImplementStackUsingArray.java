

import java.util.*;

// user defined class for generic stack
class stack<T> {
    ArrayList<T> arr;
    int top = -1;
    int size;

    stack(int cap) {
        this.size=cap;
        arr = new ArrayList<T>(size);
    }

    void push(T ele) {
        if (top + 1 == size) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr.add(ele);
        }

    }

    T pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            T topVal = arr.remove(top);
            top--;
            return topVal;
        }
    }

    T top() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr.get(top);
    }

    boolean empty() { return top == -1; }

    public String toString()
    {
        String Ans = "";
        for (int i = top; i >=0; i--) {
            Ans += String.valueOf(arr.get(i)) + "<-";
        }
        return Ans;
    }

}





// Main Class
public class StackUsingArray{

    // main driver method
    public static void main(String[] args)
    {
        stack<Integer> s1 = new stack<Integer>(3);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(
                "s1 after pushing 10, 20 and 30 :\n" + s1);

        s1.pop();
        System.out.println("s1 after pop :\n" + s1);

        stack<String> s2 = new stack<>(3);
        s2.push("hello");
        s2.push("world");
        s2.push("java");
        System.out.println(
                "\ns2 after pushing 3 elements :\n" + s2);

        System.out.println(
                "s2 after pushing 4th element :");
        s2.push("GFG");


        stack<Float> s3 = new stack<>(2);
        s3.push(100.0f);
        s3.push(200.0f);
        System.out.println(
                "\ns3 after pushing 2 elements :\n" + s3);
        System.out.println("top element of s3:\n"
                + s3.top());
    }
}

//Time complexity of all the four operations is o(1)
