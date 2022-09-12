
class Queue{
    int front,rear,capacity;
    int queue[];

    Queue(int cap){
        front=rear=0;
        capacity=cap;
        queue=new int[capacity];
    }

    void Enqueue(int data){
        if (capacity==rear){
            System.out.println("Queue is full");
        }
        else {
            queue[rear] = data;
            rear++;
        }
    }

    void Dequeue(){
        if (front==rear){
            System.out.println("Queue is Empty");
        }
        else {
            for(int i=0;i<rear-1;i++){
                queue[i]=queue[i+1];
            }
            if (rear < capacity) {
                queue[rear]=0;
            }
            rear--;
        }
    }

    int front(){

        if (front==rear){
            return 0;
        }
        else{
            int frontValue=queue[front];
            return frontValue;
        }

    }

    void displayQueue() {
        if (front == rear) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = front; i < rear; i++) {
                System.out.printf("%d<-", queue[i]);
            }
            System.out.println("");
        }
    }
}




public class QueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(4);

        q.Enqueue(20);
        q.Enqueue(30);
        q.Enqueue(40);
        q.Enqueue(50);

        q.displayQueue();
        q.Enqueue(60);

        q.displayQueue();

        q.Dequeue();
        q.Dequeue();
        System.out.printf("\nafter two node deletion\n");

        q.displayQueue();

        int fr = q.front();
        System.out.println(fr);
    }
}


